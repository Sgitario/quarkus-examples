package acme;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;

import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.junit.jupiter.api.Test;

import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class MyClientTest {

    @TestHTTPResource
    URI baseUri;

    @Test
    public void shouldPassPathParamsToSubResource() {
        String result = RestClientBuilder.newBuilder().baseUri(baseUri)
                .build(RootClient.class)
                .sub("rt", "1")
                .direct("2");
        assertEquals("rt/1/direct/2", result);
    }

    @Test
    public void shouldPassPathParamsToSubSubResource() {
        String result = RestClientBuilder.newBuilder().baseUri(baseUri)
                .build(RootClient.class)
                .sub("rt", "1")
                .sub("2")
                .direct("3");
        assertEquals("rt/1/sub/2/3", result);
    }
}
