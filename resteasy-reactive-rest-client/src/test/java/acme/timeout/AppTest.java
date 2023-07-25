package acme.timeout;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

import io.quarkus.rest.client.reactive.QuarkusRestClientBuilder;
import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.ProcessingException;

@QuarkusTest
public class AppTest {

    @TestHTTPResource
    URI baseUri;

    @Test
    void testTimeout() {
        acme.timeout.Client client = QuarkusRestClientBuilder.newBuilder().baseUri(baseUri)
                .readTimeout(1, TimeUnit.SECONDS)
                .build(acme.timeout.Client.class);
        assertThrows(ProcessingException.class, () -> client.get());
    }
}
