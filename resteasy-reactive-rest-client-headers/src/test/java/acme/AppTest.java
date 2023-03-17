package acme;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.util.List;

import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.junit.jupiter.api.Test;

import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class AppTest {

    @TestHTTPResource
    URI baseUri;

    @Test
    void testHeadersWithList() {
        SimpleHeadersClient client = RestClientBuilder.newBuilder().baseUri(baseUri).build(SimpleHeadersClient.class);
        assertEquals("a, b, c, d", client.headersList(List.of("a", "b"), List.of("c, d")));
    }
}
