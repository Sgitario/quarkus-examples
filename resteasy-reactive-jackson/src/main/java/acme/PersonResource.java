package acme;

import io.quarkus.vertx.http.Compressed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/person")
public class PersonResource {

    @Compressed
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Person get() {
        return new Person("Jose");
    }
}
