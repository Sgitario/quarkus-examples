package acme;

import org.jboss.resteasy.reactive.RestStreamElementType;

import io.smallrye.mutiny.Multi;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/sse")
@Produces(MediaType.APPLICATION_JSON)
public class SeeResource {
    @GET
    @RestStreamElementType(MediaType.APPLICATION_JSON)
    @Path("/items")
    public Multi<Dto> getItems() {
        return Multi.createFrom().items(new Dto("foo", "bar"), new Dto("chocolate", "bar"));
    }
}
