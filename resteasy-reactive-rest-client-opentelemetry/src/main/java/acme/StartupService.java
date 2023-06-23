package acme;

import java.net.URI;

import org.eclipse.microprofile.rest.client.RestClientBuilder;

import io.opentelemetry.instrumentation.annotations.WithSpan;
import io.quarkus.runtime.Startup;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

@Startup
@ApplicationScoped
public class StartupService {

    @PostConstruct
    void onStart() {
        process("hobbit");
    }

    @WithSpan
    public void process(String query) {
        String response = RestClientBuilder.newBuilder()
                .baseUri(URI.create("https://openlibrary.org")).build(OpenLibraryService.class).search(query);

        System.out.println(response);

    }
}