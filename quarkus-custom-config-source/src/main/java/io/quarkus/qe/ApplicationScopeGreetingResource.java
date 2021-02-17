package io.quarkus.qe;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/application-api")
@ApplicationScoped
public class ApplicationScopeGreetingResource {

    @Inject
    GreetingService requestScopeService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello " + requestScopeService.getProperty();
    }
}