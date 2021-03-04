package io.quarkus.qe;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class MyEnabledTest {

    @Test
    @Disabled("Disabled for whatever reason")
    public void anotherTest() {
        // ...
    }
}