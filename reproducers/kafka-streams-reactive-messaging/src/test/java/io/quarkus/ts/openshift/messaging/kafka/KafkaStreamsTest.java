package io.quarkus.ts.openshift.messaging.kafka;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.sse.SseEventSource;

import org.awaitility.Awaitility;
import org.eclipse.microprofile.config.ConfigProvider;
import org.junit.jupiter.api.Test;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.ts.openshift.messaging.kafka.aggregator.model.LoginAggregation;
import io.restassured.RestAssured;

@QuarkusTest
@QuarkusTestResource(StrimziKafkaResource.class)
public class KafkaStreamsTest {

    private static final int ssePort = ConfigProvider.getConfig().getValue("quarkus.http.test-port", Integer.class);

    private static final int TIMEOUT_SEC = 25;
    private static final int EVENTS_AMOUNT = 3;

    private Client client = ClientBuilder.newClient();
    private List<LoginAggregation> receive = new CopyOnWriteArrayList<>();
    private boolean completed;

    @Test
    public void testAlertMonitorEventStream() throws InterruptedException {
        givenHealthCheckIsUp();
        whenRequestSomeEvents(EVENTS_AMOUNT);
        thenVerifyAllEventsArrived();
    }

    private void givenHealthCheckIsUp() {
        Awaitility.await().atMost(Duration.ofSeconds(5)).untilAsserted(() -> RestAssured.when().get("/q/health/ready").then()
                .body("status", is("UP")));
    }

    private void whenRequestSomeEvents(int amount) throws InterruptedException {
        WebTarget target = client.target(appUrl() + "/monitor/stream");
        final CountDownLatch latch = new CountDownLatch(amount);

        SseEventSource source = SseEventSource.target(target).build();
        source.register(inboundSseEvent -> {
            receive.add(inboundSseEvent.readData(LoginAggregation.class, MediaType.APPLICATION_JSON_TYPE));
            latch.countDown();
        });

        source.open();
        completed = latch.await(TIMEOUT_SEC, TimeUnit.SECONDS);
        source.close();
    }

    private void thenVerifyAllEventsArrived() {
        assertTrue(completed, "Not all expected kafka events has been consumed.");
    }

    private String appUrl() {
        return "http://localhost:" + ssePort;
    }
}
