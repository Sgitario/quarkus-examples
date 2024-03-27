package acme;

import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.stream.Collectors;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;

@Path("/headers")
public class HeaderResource {
    @GET
    @Path("/header-param-list")
    public Object headerParamWithList(@HeaderParam("header") List list) {
        return list.stream().collect(Collectors.joining(", "));
    }

    @GET
    @Path("/header-param-set")
    public Object headerParamWithSet(@HeaderParam("header") Set list) {
        return list.stream().collect(Collectors.joining(", "));
    }

    @GET
    @Path("/header-param-sorted-set")
    public Object headerParamWithSortedSet(@HeaderParam("header") SortedSet list) {
        return list.stream().collect(Collectors.joining(", "));
    }
}
