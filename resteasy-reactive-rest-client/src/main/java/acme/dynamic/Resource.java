package acme.dynamic;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("/dynamic")
public class Resource {
    @GET
    @Path("/a")
    public String getA() {
        return "Hello A";
    }

    @GET
    @Path("/b")
    public String getB() {
        return "Hello B";
    }

    @GET
    @Path("/b/d")
    public String getComplex(@QueryParam("foo") String foo) {
        return "Hello B/D: " + foo;
    }
}
