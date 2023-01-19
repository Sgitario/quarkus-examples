package acme;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class SpringDataRestTest {

    private static final int DOSTOEVSKY_ID = 1;

    private static final String DOSTOEVSKY_NAME = "Fyodor Dostoevsky";

    private static final String DOSTOEVSKY_DOB = "1821-11-11";

    @Test
    void shouldGetAuthor() {
        given().accept("application/json")
                .when().get("/authors/" + DOSTOEVSKY_ID)
                .then().statusCode(200)
                .and().body("id", is(equalTo(DOSTOEVSKY_ID)))
                .and().body("name", is(equalTo(DOSTOEVSKY_NAME)))
                .and().body("dob", is(equalTo(DOSTOEVSKY_DOB)));
    }
}
