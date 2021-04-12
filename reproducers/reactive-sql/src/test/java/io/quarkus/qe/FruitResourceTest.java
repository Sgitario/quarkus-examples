package io.quarkus.qe;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import io.netty.handler.codec.http.HttpResponseStatus;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
@QuarkusTestResource(PostgresqlResource.class)
public class FruitResourceTest {
    @Inject
    FruitResource resource;

    @Test
    public void shouldNotInsertFruitIfValidationError() {
        given().accept(ContentType.JSON).body(wrong())
                .when()
                .post("/insert")
                .then()
                .statusCode(HttpResponseStatus.CREATED.code());
    }

    @Test
    public void shouldInsertTwoFruits() throws InterruptedException {
        AtomicReference<Throwable> exception = new AtomicReference<>();
        AtomicBoolean failed = new AtomicBoolean(true);
        CountDownLatch latch = new CountDownLatch(1);

        resource.insertTwoFruits(apple(), banana())
                .onFailure().invoke((ex) -> {
                    exception.set(ex);
                    failed.set(true);
                    latch.countDown();
                })
                .subscribe().with(obj -> {
                    failed.set(false);
                    latch.countDown();
                });

        latch.await();
        assertFalse(failed.get(), "Failed with " + exception.get());
    }

    private Fruit apple() {
        return newFruit(1l, "apple");
    }

    private Fruit banana() {
        return newFruit(2l, "banana");
    }

    private Fruit wrong() {
        return newFruit(3l, null);
    }

    private Fruit newFruit(Long id, String name) {
        Fruit fruit = new Fruit();
        fruit.id = id;
        fruit.name = name;
        return fruit;
    }
}
