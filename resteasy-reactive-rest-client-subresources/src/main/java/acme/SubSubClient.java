package acme;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Consumes("text/plain")
@Produces("text/plain")
public interface SubSubClient {

    @GET
    @Path("/{methodParam}")
    String direct(@PathParam("methodParam") String methodParam);
}
