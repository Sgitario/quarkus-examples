package acme;

import java.util.Arrays;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

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
