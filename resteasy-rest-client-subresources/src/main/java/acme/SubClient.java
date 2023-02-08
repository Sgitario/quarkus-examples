package acme;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Consumes("text/plain")
@Produces("text/plain")
public interface SubClient {

    @GET
    @Path("/sub/{methodParam}")
    String sub(@PathParam("methodParam") String methodParam);
}
