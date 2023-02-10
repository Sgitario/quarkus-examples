package acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/person")
public class PersonResource {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Person get() {
        return new Person("Jose");
    }
}
