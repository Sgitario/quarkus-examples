package acme;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.jester.api.Jester;
import io.jester.api.Quarkus;

@Jester
@Quarkus
public class OpenShiftS2iIT {
    @Test
    public void test() {
        String response = given().get("/greetings").thenReturn().asString();
        assertEquals("Hello, world!", response);
    }
}
