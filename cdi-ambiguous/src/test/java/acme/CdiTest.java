package acme;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;

@QuarkusTest
public class CdiTest {

    @Inject
    CarResource car;

    @Inject
    Car defaultCar;

    @Test
    public void resolveAmbiguousResolution() {
        assertEquals("one car on behalf of ford", car.model());
        assertEquals("one car on behalf of ford", RestAssured.get("/cars").then().extract().asString());
        assertEquals("ford", defaultCar.model());
    }
}
