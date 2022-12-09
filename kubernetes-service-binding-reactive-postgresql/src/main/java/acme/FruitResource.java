package acme;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;

@Path("fruits")
public class FruitResource {

    @GET
    @Blocking
    @Produces("application/json")
    @Consumes("application/json")
    public Uni<List<Fruit>> get() {
        return Fruit.listAll();
    }
}
