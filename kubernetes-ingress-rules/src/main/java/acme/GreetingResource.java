package acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/greetings")
public class GreetingResource {

    @GET
    public String hello() {
        return "Hello, world!";
    }
}
