package io.quarkus.qe;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.apache.http.HttpStatus;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import io.quarkus.qe.ping.PingResource;
import io.quarkus.qe.ping.PongClient;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import io.quarkus.qe.pong.PongResource;
import io.quarkus.qe.utils.PropertiesUtils;
import io.quarkus.test.QuarkusProdModeTest;

public class PingPongResourceTest {

    private static final int PING_PORT = 8081;
    private static final int PORT_PORT = 8082;

    @RegisterExtension
    static final QuarkusProdModeTest pongApp = new QuarkusProdModeTest()
            .setArchiveProducer(() -> ShrinkWrap.create(JavaArchive.class)
                    .addClasses(PongResource.class))
            .setRun(true)
            .setRuntimeProperties(PropertiesUtils.toMap("pong.properties"));

    @RegisterExtension
    static final QuarkusProdModeTest pingApp = new QuarkusProdModeTest()
            .setArchiveProducer(() -> ShrinkWrap.create(JavaArchive.class)
                    .addClasses(PingResource.class, PongClient.class))
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
    }
}
