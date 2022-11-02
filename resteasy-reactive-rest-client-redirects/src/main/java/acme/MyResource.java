package acme;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/")
@ApplicationScoped
public class MyResource {

    @GET
    @Path("/endpoint-redirect")
    public Response redirectToUsingGet() {
        return Response.status(Response.Status.MOVED_PERMANENTLY).header("Location", "http://localhost:8081/endpoint").build();
    }

    @GET
    @Path("/endpoint")
    public String endpointUsingGet() {
        return "Hello";
    }

    @POST
    @Path("/endpoint-redirect")
    public Response redirectToUsingPost() {
        return Response.status(Response.Status.MOVED_PERMANENTLY).header("Location", "http://localhost:8081/endpoint").build();
    }

    @POST
    @Path("/endpoint")
    public String endpointUsingPost() {
        return "Hello";
    }
}
