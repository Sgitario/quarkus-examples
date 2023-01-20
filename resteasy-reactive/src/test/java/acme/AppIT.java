package acme;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.charset.StandardCharsets;

import javax.ws.rs.core.MediaType;

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
        String response = given().get("/ping").thenReturn().asString();
        assertEquals("pong", response);
    }

    @Test
    public void testPlainTextFilePartFromMultipart() {
        // verifies that every multipart form data field regardless of media type can be used as file
        // as long as Java data type of DTO field is java.io.File
        String text = "Old Time Rock & Roll";
        MultiPartSpecification textSpec = new MultiPartSpecBuilder(text.getBytes(StandardCharsets.UTF_8))
                .controlName("plainTextFile")
                .fileName("plainTextFile")
                .header("Content-Type", MediaType.TEXT_PLAIN)
                .build();
        String receivedString = RestAssured.given()
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .multiPart(textSpec)
                .log().all()
                .post("/multipart/plain-text-file")
                .then()
                .statusCode(200)
                .extract()
                .asString();
        assertThat(receivedString, equalTo(text));
    }
}
