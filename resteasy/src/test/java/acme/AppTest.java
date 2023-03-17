package acme;

import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import io.github.snowdrop.jester.api.Jester;
import io.github.snowdrop.jester.api.Quarkus;
import io.restassured.RestAssured;

@Jester @Quarkus
public class AppTest {
    @Test
    public void testHeaderParamUsingCollection() {
        RestAssured.with().header("header", "a", "b")
                .get("/headers/header-param-list")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(Matchers.equalTo("a, b"));

        RestAssured.with().header("header", "a", "b")
                .get("/headers/header-param-set")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(Matchers.equalTo("a, b"));

        RestAssured.with().header("header", "a", "b")
                .get("/headers/header-param-sorted-set")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(Matchers.equalTo("a, b"));
    }
}
