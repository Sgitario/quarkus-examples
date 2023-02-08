package acme;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

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
