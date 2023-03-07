package acme;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import io.github.snowdrop.jester.api.Jester;
import io.github.snowdrop.jester.api.Quarkus;

// Disabled because the ConfigMap 'app-config' is not found when running the test which is expected
@Disabled
@Jester
@Quarkus(forceBuild = true)
public class OpenShiftIT {
    @Test
    public void test() {
        String response = given().get("/greetings").thenReturn().asString();
        assertEquals("Hello, world!", response);
    }
}
