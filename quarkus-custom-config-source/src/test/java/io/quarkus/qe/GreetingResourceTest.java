package io.quarkus.qe;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.apache.http.HttpStatus;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class GreetingResourceTest {

    private static final String CUSTOM_PROPERTY = "my.property";
    private static final String REQUEST_SCOPE_PATH = "/request-api";
    private static final String APPLICATION_SCOPE_PATH = "/application-api";
    private static final String EVENT_APPLICATION_SCOPE_PATH = "/event-application-api";

    private static final String DEFAULT_VALUE = "Default";
    private static final String TEST_VALUE = "Test";

    @BeforeEach
    public void setup() {
        whenUpdateCustomPropertyTo(DEFAULT_VALUE);
    }

    @Test
    public void shouldUpdateCustomPropertyUsingRequestScope() {
        thenGreetingsApiReturns(REQUEST_SCOPE_PATH, "Hello " + DEFAULT_VALUE);

        whenUpdateCustomPropertyTo(TEST_VALUE);
        thenGreetingsApiReturns(REQUEST_SCOPE_PATH, "Hello " + TEST_VALUE);
    }

    @Test
    public void shouldUpdateCustomPropertyUsingApplicationScope() {
        thenGreetingsApiReturns(APPLICATION_SCOPE_PATH, "Hello " + DEFAULT_VALUE);

        whenUpdateCustomPropertyTo(TEST_VALUE);
        thenGreetingsApiReturns(APPLICATION_SCOPE_PATH, "Hello " + TEST_VALUE);
    }

    @Test
    public void shouldUpdateCustomPropertyUsingEvents() {
        thenGreetingsApiReturns(EVENT_APPLICATION_SCOPE_PATH, "Hello " + DEFAULT_VALUE);

        whenUpdateCustomPropertyTo(TEST_VALUE);
        thenGreetingsApiReturns(EVENT_APPLICATION_SCOPE_PATH, "Hello " + TEST_VALUE);
    }

    private void whenUpdateCustomPropertyTo(String newValue) {
        given().port(8081).body(newValue).put("/microprofile-ext/memoryconfigsource/key/" + CUSTOM_PROPERTY).then()
                .statusCode(HttpStatus.SC_ACCEPTED);
    }

    private void thenGreetingsApiReturns(String path, String expected) {
        Awaitility.await().atMost(Duration.ofSeconds(5)).untilAsserted(() -> {
            String actual = given().port(8081).get(path)
                    .then().statusCode(HttpStatus.SC_OK)
                    .extract().asString();

            assertEquals(expected, actual, "Unexpected response from service");
        });
    }
}
