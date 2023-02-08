package acme;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Consumes("text/plain")
@Produces("text/plain")
public interface SubClient {

    @Path("/sub/{methodParam}")
    SubSubClient sub(@PathParam("methodParam") String methodParam);

    @GET
    @Path("/direct/{methodParam}")
    String direct(@PathParam("methodParam") String methodParam);
}
