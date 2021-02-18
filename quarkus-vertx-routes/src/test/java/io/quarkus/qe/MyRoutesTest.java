package io.quarkus.qe;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.emptyString;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class MyRoutesTest {

    @Test
    public void test() {
        // Valid result
        get("/valid").then().statusCode(200)
                .body("name", is("luke"))
                .body("welcome", is("hello"));

        // Valid parameter
        given()
                .queryParam("name", "neo")
                .when()
                .get("/query")
                .then().statusCode(200);

        // JSON output
        given()
                .header("Accept", "application/json")
                .when()
                .get("/invalid")
                .then()
                .statusCode(500)
                .body("title", containsString("Constraint Violation"))
                .body("status", is(500))
                .body("details", containsString("validation constraint violations"))
                .body("violations[0].field", containsString("name"))
                .body("violations[0].message", is(not(emptyString())));

        // JSON output as it\s a Uni of object
        given()
                .when()
                .get("/invalid")
                .then()
                .statusCode(500)
                .body("title", containsString("Constraint Violation"))
                .body("status", is(500))
                .body("details", containsString("validation constraint violations"))
                .body("violations[0].field", containsString("name"))
                .body("violations[0].message", is(not(emptyString())));

        given()
                .header("Accept", "application/json")
                .when()
                .get("/invalid2").then().statusCode(500)
                .body("title", containsString("Constraint Violation"))
                .body("status", is(500))
                .body("details", containsString("validation constraint violations"))
                .body("violations[0].field", anyOf(containsString("name"), containsString("welcome")))
                .body("violations[0].message", is(not(emptyString())))
                .body("violations[1].field", anyOf(containsString("name"), containsString("welcome")))
                .body("violations[1].message", is(not(emptyString())));

        // Input parameter violation - JSON
        given()
                .header("Accept", "application/json")
                .queryParam("name", "doesNotMatch")
                .when()
                .get("/query")
                .then().statusCode(400)
                .body("title", containsString("Constraint Violation"))
                .body("status", is(400))
                .body("details", containsString("validation constraint violations"))
                .body("violations[0].field", containsString("name"))
                .body("violations[0].message", is(not(emptyString())));
    }
}
