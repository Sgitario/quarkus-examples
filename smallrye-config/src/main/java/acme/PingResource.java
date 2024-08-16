package acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/ping")
public class PingResource {

    @ConfigProperty(name = "property")
    String property;

    @GET
    public String get() {
        return property;
    }
}
