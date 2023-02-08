package acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "my")
public interface MyClient {
    @GET
    @Path("/endpoint-redirect")
    String callUsingGet();

    @POST
    @Path("/endpoint-redirect")
    String callUsingPost();
}
