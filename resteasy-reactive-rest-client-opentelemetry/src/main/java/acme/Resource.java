package acme;

import java.net.URI;

import org.eclipse.microprofile.rest.client.RestClientBuilder;

import io.opentelemetry.instrumentation.annotations.WithSpan;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/process")
public class Resource {

    @GET
    public void get() {
        process("hobbit");
    }

    @WithSpan
    public void process(String query) {
        String response = RestClientBuilder.newBuilder()
                .baseUri(URI.create("https://openlibrary.org")).build(OpenLibraryService.class).search(query);

        System.out.println(response);

    }
}
