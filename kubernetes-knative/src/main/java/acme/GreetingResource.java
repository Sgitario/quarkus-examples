package acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import io.micrometer.core.instrument.MeterRegistry;

@Path("/greetings")
public class GreetingResource {

    @Inject
    MeterRegistry registry;

    @GET
    public String hello() {
        registry.counter("greeting_counter").increment();
        return "Hello, world!";
    }
}
