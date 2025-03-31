package acme;

import io.github.snowdrop.jester.api.Jester;
import io.github.snowdrop.jester.api.Quarkus;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

@Jester @Quarkus(forceBuild = true)
public class QueryTest {
    @Test
    public void testQueryWhenAbsent() {
        RestAssured.get("/queries")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(Matchers.equalTo("Value was: null"));
    }

    @Test
    public void testQueryWhenEmpty() {
        RestAssured.given().param("value", "")
            .get("/queries")
            .then()
            .statusCode(HttpStatus.SC_OK)
            .body(Matchers.equalTo("Value was: "));
    }

    @Test
    public void testQueryWhenSet() {
        RestAssured.given().param("value", "hello")
            .get("/queries")
            .then()
            .statusCode(HttpStatus.SC_OK)
            .body(Matchers.equalTo("Value was: hello"));
    }
}
