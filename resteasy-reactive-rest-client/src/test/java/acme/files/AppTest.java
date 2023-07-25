package acme.files;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;

import org.junit.jupiter.api.Test;

import io.quarkus.rest.client.reactive.QuarkusRestClientBuilder;
import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class AppTest {

    @TestHTTPResource
    URI baseUri;

    @Test
    void testDownloadFile() throws IOException {
        Client client = QuarkusRestClientBuilder.newBuilder().baseUri(baseUri).build(Client.class);
        assertEquals("Lorem ipsum dolor sit amet", Files.readString(client.getFile().toPath()));
    }

    @Test
    void testDownloadInputStream() throws IOException {
        Client client = QuarkusRestClientBuilder.newBuilder().baseUri(baseUri).build(Client.class);
        assertEquals("Lorem ipsum dolor sit amet", new String(client.getInputStream().readAllBytes()));
    }
}
