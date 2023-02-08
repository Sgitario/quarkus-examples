package acme;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/path/{rootParam}")
@RegisterRestClient(baseUri = "http://localhost:8081")
@Consumes("text/plain")
@Produces("text/plain")
public interface RootClient {

    @Path("/{methodParam}")
    SubClient sub(@PathParam("rootParam") String rootParam, @PathParam("methodParam") String methodParam);
}
