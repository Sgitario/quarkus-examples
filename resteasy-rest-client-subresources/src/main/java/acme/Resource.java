package acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/path")
public class Resource {

    @GET
    @Path("{part1}/{part2}/{part3}")
    public String getUriParts(@PathParam("part1") String part1,
            @PathParam("part2") String part2,
            @PathParam("part3") String part3) {
        return String.format("%s/%s/%s", part1, part2, part3);
    }

    @GET
    @Path("{part1}/{part2}/{part3}/{part4}")
    public String getUriParts(@PathParam("part1") String part1,
            @PathParam("part2") String part2,
            @PathParam("part3") String part3,
            @PathParam("part4") String part4) {
        return String.format("%s/%s/%s/%s", part1, part2, part3, part4);
    }

    @GET
    @Path("{part1}/{part2}/{part3}/{part4}/{part5}")
    public String getUriParts(@PathParam("part1") String part1,
            @PathParam("part2") String part2,
            @PathParam("part3") String part3,
            @PathParam("part4") String part4,
            @PathParam("part5") String part5) {
        return String.format("%s/%s/%s/%s/%s", part1, part2, part3, part4, part5);
    }
}
