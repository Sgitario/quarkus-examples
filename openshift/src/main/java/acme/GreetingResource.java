package acme;

import java.util.Arrays;
import java.util.stream.Collectors;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/greetings")
public class GreetingResource {

    @ConfigProperty(name = "hello.message")
    String message;

    @GET
    public String hello() {
        return message;
    }

    @GET
    @Path("/arguments")
    public String argument() {
        return ProcessHandle.current().info().arguments().stream()
                .flatMap(l -> Arrays.stream(l))
                .collect(Collectors.joining( " "));
    }
}
