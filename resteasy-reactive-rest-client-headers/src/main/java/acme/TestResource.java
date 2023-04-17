package acme;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.jboss.resteasy.reactive.RestHeader;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;

@Path("/")
@ApplicationScoped
public class TestResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/describe-request")
    public RequestData describeRequest(@Context HttpHeaders headers) {
        RequestData result = new RequestData();
        result.setHeaders(headers.getRequestHeaders());
        return result;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/headers-list")
    public String headersList(@HeaderParam("foo") List foo, @RestHeader List header, @QueryParam("query") String query) {
        List<String> allHeaders = new ArrayList<>();
        foo.forEach(v -> allHeaders.add((String) v));
        header.forEach(v -> allHeaders.add((String) v));
        return query + "=" + allHeaders.stream().collect(Collectors.joining(", "));
    }
}
