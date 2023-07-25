package acme.timeout;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/timeout")
public class Resource {
    @GET
    public String get() throws InterruptedException {
        Thread.sleep(10000l);
        return "hola";
    }
}
