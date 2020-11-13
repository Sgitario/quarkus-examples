package io.quarkus.qe;

import static io.restassured.RestAssured.given;
import static org.awaitility.Awaitility.await;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.apache.http.HttpStatus;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import io.quarkus.qe.containers.JaegerContainer;
import io.quarkus.qe.ping.PingResource;
import io.quarkus.qe.ping.PongClient;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import io.quarkus.qe.pong.PongResource;
import io.quarkus.qe.traceable.TraceableResource;
import io.quarkus.qe.utils.PropertiesUtils;
import io.quarkus.test.QuarkusProdModeTest;

@Testcontainers
public class PingPongResourceTest {

    private static final int PING_PORT = 8081;
    private static final int PORT_PORT = 8082;

    @Container
    static final JaegerContainer jaeger = new JaegerContainer();

    @RegisterExtension
    static final QuarkusProdModeTest pongApp = new QuarkusProdModeTest()
            .setArchiveProducer(() -> ShrinkWrap.create(JavaArchive.class)
                    .addClasses(TraceableResource.class, PongResource.class))
            .setRun(true)
            .setRuntimeProperties(PropertiesUtils.toMap("pong.properties"));

    @RegisterExtension
    static final QuarkusProdModeTest pingApp = new QuarkusProdModeTest()
            .setArchiveProducer(() -> ShrinkWrap.create(JavaArchive.class)
                    .addClasses(TraceableResource.class, PingResource.class, PongClient.class))
            .setRun(true)
            .setRuntimeProperties(PropertiesUtils.toMap("ping.properties"));

    @Test
    public void testPong() {
        given()
                .when().port(PORT_PORT).get("/pong")
                .then().statusCode(HttpStatus.SC_OK)
                .body(is("pong"));
    }

    @Test
    public void testPingPong() {
        given()
                .when().port(PING_PORT).get("/ping")
                .then().statusCode(HttpStatus.SC_OK)
                .body(is("ping pong"));

        // Then both ping and pong rest endpoints should have the same trace Id.
        String pingTraceId = given()
                .when().port(PING_PORT).get("/ping/lastTraceId")
                .then().statusCode(HttpStatus.SC_OK).and().extract().asString();

        String pongTraceId = given()
                .when().port(PORT_PORT).get("/pong/lastTraceId")
                .then().statusCode(HttpStatus.SC_OK).and().extract().asString();

        assertEquals(pingTraceId, pongTraceId);

        // Then Jaeger is invoked
        await().atMost(5, TimeUnit.SECONDS).untilAsserted(() -> given()
                .when().get("http://localhost:16686/api/traces/" + pingTraceId)
                .then().statusCode(HttpStatus.SC_OK)
                .and().body(allOf(containsString(PingResource.class.getName()), containsString(PongResource.class.getName()))));
    }
}
