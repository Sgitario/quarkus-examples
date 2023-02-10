package acme;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.charset.StandardCharsets;

import io.restassured.http.ContentType;
import jakarta.ws.rs.core.MediaType;

import org.junit.jupiter.api.Test;

import io.jester.api.Jester;
import io.jester.api.Quarkus;
import io.restassured.RestAssured;
import io.restassured.builder.MultiPartSpecBuilder;
import io.restassured.specification.MultiPartSpecification;

@Jester
@Quarkus(forceBuild = true)
public class AppIT {
    @Test
    public void test() {
        Person response = given().accept(ContentType.XML).get("/person").thenReturn().as(Person.class);
        assertEquals("Jose", response.getName());
    }
}
