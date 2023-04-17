package acme;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.RestHeader;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@RegisterRestClient
public interface SimpleHeadersClient {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/headers-list")
    String headersList(@HeaderParam("foo") List foo, @RestHeader("header") List header, @QueryParam("query") String query);
}
