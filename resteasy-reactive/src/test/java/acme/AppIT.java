package acme;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.jester.api.Jester;
import io.jester.api.Quarkus;

@Jester
@Quarkus(forceBuild = true)
public class AppIT {
    @Test
    public void test() {
        String response = given().get("/ping").thenReturn().asString();
        assertEquals("pong", response);
    }
}
