package acme;

import jakarta.annotation.Priority;
import jakarta.enterprise.inject.Alternative;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Priority(10)
@Path("/cars")
public class CarResource implements Car {
    @Inject
    Ford car;

    @GET
    @Override
    public String model() {
        return "one car on behalf of " + car.model();
    }
}
