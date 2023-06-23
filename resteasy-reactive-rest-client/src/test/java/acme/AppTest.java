package acme;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;

import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.junit.jupiter.api.Test;

import acme.dynamic.Client;
import acme.dynamic.MyClientRequestFilter;
import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class AppTest {

    @TestHTTPResource
    URI baseUri;

    @Test
    void testClientA() {
        Client client = RestClientBuilder.newBuilder().baseUri(baseUri).build(Client.class);
        assertEquals("Hello A", client.callA());
    }

    @Test
    void testClientB() {
        Client client = RestClientBuilder.newBuilder().baseUri(baseUri).build(Client.class);
        assertEquals("Hello B", client.callB());
    }

    @Test
    void testClientBoth() {
        Client client = RestClientBuilder.newBuilder().baseUri(baseUri).build(Client.class);
        assertEquals("Hello A", client.call("a"));
        assertEquals("Hello B", client.call("b"));
        assertEquals("Hello B/D: null", client.call("b/d"));
    }

    @Test
    void testClientComplex() {
        Client client = RestClientBuilder.newBuilder()
                .register(MyClientRequestFilter.class)
                .baseUri(baseUri)
                .build(Client.class);
        assertEquals("Hello B/D: bar", client.callComplex("/b/d?foo=bar"));
    }
}