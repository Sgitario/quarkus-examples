package acme;

import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.junit.jupiter.api.Test;

import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class AppTest {

    @TestHTTPResource
    URI baseUri;

    @Test
    void testSse() {
        var resultList = new CopyOnWriteArrayList<>();
        RestClientBuilder.newBuilder().baseUri(baseUri).build(SeeClient.class)
                .getItems()
                .subscribe().with(resultList::add);
        await().atMost(5, TimeUnit.SECONDS)
                .untilAsserted(() -> {
                    assertTrue(resultList.contains(new Dto("foo", "bar")));
                    assertTrue(resultList.contains(new Dto("chocolate", "bar")));
                });
    }
}
