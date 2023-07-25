package acme.timeout;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;

import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.ws.rs.ProcessingException;

@QuarkusTest
public class AppTest {

    @TestHTTPResource
    URI baseUri;

    @Inject
    @RestClient
    Client client;

    @Test
    void testTimeoutUsingRestClientBuilder() {
        Client myClient = RestClientBuilder.newBuilder().baseUri(baseUri)
                .readTimeout(1, TimeUnit.SECONDS)
                .build(Client.class);
        assertThrows(ProcessingException.class, () -> myClient.get());
    }

    @Test
    void testTimeoutUsingInjectedRestClient() {
        assertThrows(ProcessingException.class, () -> client.get());
    }
}
