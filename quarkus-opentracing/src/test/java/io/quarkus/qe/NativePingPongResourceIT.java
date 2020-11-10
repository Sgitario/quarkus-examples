package io.quarkus.qe;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.NativeImageTest;

@NativeImageTest
public class NativePingPongResourceIT {

    @Test
    public void testPingPong() {
        // When calling ping, the rest will invoke also the pong rest endpoint.
        given()
                .when().get("/ping")
                .then().statusCode(HttpStatus.SC_OK)
                .body(is("ping pong"));
    }
}
