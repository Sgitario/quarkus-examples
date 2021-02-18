package io.quarkus.qe;

import javax.enterprise.event.Observes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.microprofileext.config.event.ChangeEvent;
import org.microprofileext.config.event.Type;

@Path("/event-application-api")
public class WithEventsApplicationScopeGreetingResource {

    private static final String PROPERTY = "my.property";

    @ConfigProperty(name = PROPERTY)
    String property;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello " + property;
    }

    public void all(@Observes ChangeEvent changeEvent) {
        if (PROPERTY.equals(changeEvent.getKey()) && changeEvent.getType() == Type.UPDATE) {
            property = changeEvent.getNewValue();
        }
    }
}