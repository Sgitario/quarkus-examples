package io.quarkus.qe;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import io.micrometer.core.instrument.MeterRegistry;

@Path("/hello")
public class GreetingsResource {

    @Inject
    MeterRegistry registry;

    @GET
    public String sayHello() {
        registry.counter("greeting_counter").increment();

        return "Hello!";
    }
}
