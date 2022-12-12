package acme;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Consumes("text/plain")
@Produces("text/plain")
public interface SubClient {

    @Path("/sub/{methodParam}")
    SubSubClient sub(@PathParam("methodParam") String methodParam);

    @GET
    @Path("/direct/{methodParam}")
    String direct(@PathParam("methodParam") String methodParam);
}
