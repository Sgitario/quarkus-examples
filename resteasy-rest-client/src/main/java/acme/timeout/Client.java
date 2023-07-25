package acme.timeout;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@RegisterRestClient(configKey = "timeout")
@Path("/timeout")
public interface Client {
    @GET
    String get();
}
