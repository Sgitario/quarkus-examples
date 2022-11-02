package acme;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

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
