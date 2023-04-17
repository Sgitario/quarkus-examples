package acme;

import org.jboss.resteasy.annotations.GZIP;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/person")
public class PersonResource {

    @GZIP
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Person get() {
        return new Person("Jose");
    }
}
