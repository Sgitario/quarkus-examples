package acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/greetings")
public class GreetingResource {

    @GET
    public String hello() {
        return "Hello, world!";
    }
}
