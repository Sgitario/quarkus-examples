package acme;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.RestStreamElementType;

import io.smallrye.mutiny.Multi;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@RegisterRestClient
@Path("/sse")
public interface SeeClient {
    @GET
    @Path("/items")
    @RestStreamElementType(MediaType.APPLICATION_JSON)
    Multi<Dto> getItems();
}
