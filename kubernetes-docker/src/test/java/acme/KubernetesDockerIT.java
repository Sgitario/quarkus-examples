package acme;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import io.jester.api.Jester;
import io.jester.api.Quarkus;

@Disabled
@Jester
@Quarkus(forceBuild = true)
public class KubernetesDockerIT {
    @Test
    public void test() {
        String response = given().get("/greetings").thenReturn().asString();
        assertEquals("Hello, world!", response);
    }
}
