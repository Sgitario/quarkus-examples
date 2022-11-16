package acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/greetings")
public class GreetingResource {

    @ConfigProperty(name = "hello.message")
    String message;

    @GET
    public String hello() {
        return message;
    }
}
