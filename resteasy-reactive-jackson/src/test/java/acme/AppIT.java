package acme;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.github.snowdrop.jester.api.Jester;
import io.github.snowdrop.jester.api.Quarkus;
import io.restassured.http.ContentType;

@Jester
@Quarkus(forceBuild = true)
public class AppIT {
    @Test
    public void test() {
        Person response = given().accept(ContentType.JSON).get("/person").thenReturn().as(Person.class);
        assertEquals("Jose", response.getName());
    }
}
