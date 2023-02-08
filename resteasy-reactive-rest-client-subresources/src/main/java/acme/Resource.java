package acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import org.jboss.resteasy.reactive.RestPath;

@Path("/path")
public class Resource {

    @GET
    @Path("{part1}/{part2}/{part3}")
    public String getUriParts(@RestPath String part1, @RestPath String part2, @RestPath String part3) {
        return String.format("%s/%s/%s", part1, part2, part3);
    }

    @GET
    @Path("{part1}/{part2}/{part3}/{part4}")
    public String getUriParts(@RestPath String part1, @RestPath String part2, @RestPath String part3, @RestPath String part4) {
        return String.format("%s/%s/%s/%s", part1, part2, part3, part4);
    }

    @GET
    @Path("{part1}/{part2}/{part3}/{part4}/{part5}")
    public String getUriParts(@RestPath String part1, @RestPath String part2, @RestPath String part3, @RestPath String part4,
            @RestPath String part5) {
        return String.format("%s/%s/%s/%s/%s", part1, part2, part3, part4, part5);
    }
}
