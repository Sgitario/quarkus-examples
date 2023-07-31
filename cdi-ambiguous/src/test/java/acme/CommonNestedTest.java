package acme;

import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;

public abstract class CommonNestedTest {

    public String defaultProfile() {
        return "Hello";
    }

    @Nested
    class NestedTests {
        @Test
        public void testProfileFromNested() {
            RestAssured.given().log().all()
                    .get("/greeting/Stu")
                    .then()
                    .log().all()
                    .statusCode(200)
                    .body(is(defaultProfile() + " Stu"));
        }
    }
}
