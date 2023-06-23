package acme.dynamic;

import java.util.Map;

import org.jboss.resteasy.reactive.RestQuery;

import jakarta.ws.rs.Encoded;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;

@Path("/dynamic")
public interface Client {
    @GET
    @Path("/a")
    String callA();

    @GET
    @Path("/b")
    String callB();

    @Encoded
    @GET
    @Path("/{who}")
    String call(@PathParam("who") String who);

    @GET
    @Path("/{part1}/{part2}")
    String call(@PathParam("part1") String part1, @PathParam("part2") String part2, @RestQuery Map<String, String> queries);

    @GET
    String callComplex(@HeaderParam("abs") String abs);

    @GET
    String callWithQuery(@Encoded @QueryParam("query") String query);
}
