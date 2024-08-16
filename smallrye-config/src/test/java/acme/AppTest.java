package acme;

import io.quarkus.test.junit.QuarkusTest;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;

@QuarkusTest
class AppTest {
    @Test
    void testHeaderParamUsingCollection() {
        get("/ping")
                .then()
                .statusCode(HttpStatus.SC_OK)
                // loaded from config source
                .body(Matchers.equalTo("pong"));
    }
}
