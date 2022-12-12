package acme;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class MyClientTest {
    @RestClient
    RootClient client;

    @Test
    public void shouldPassPathParamsToSubResource() {
        // should result in sending GET /path/rt/mthd/sub/s
        SubClient subClient = client.sub("rt", "mthd");
        String result = subClient.sub("s");
        assertEquals("rt/mthd/sub/s", result);
    }
}
