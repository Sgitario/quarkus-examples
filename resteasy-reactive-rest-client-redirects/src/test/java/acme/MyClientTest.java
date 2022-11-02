package acme;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class MyClientTest {
    @RestClient
    MyClient client;

    @Test
    public void shouldSayHelloAfterRedirect() {
        assertEquals("Hello", client.callUsingGet());
        // redirections on post are not supported
        // assertEquals("Hello", client.callUsingPost());
    }
}
