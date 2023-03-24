package acme;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import io.smallrye.mutiny.Uni;

@Path("fruits")
public class FruitResource {

    @GET
    @Produces("application/json")
    @Consumes("application/json")
    public Uni<List<Fruit>> get() {
        return Fruit.listAll();
    }
}
