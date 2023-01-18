package acme;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

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
