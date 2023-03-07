package acme;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.github.snowdrop.jester.api.Jester;
import io.github.snowdrop.jester.api.Quarkus;

@Jester
@Quarkus(forceBuild = true)
public class KubernetesKindIT {
    @Test
    public void test() {
        String response = given().get("/greetings").thenReturn().asString();
        assertEquals("Hello, world!", response);
    }
}
