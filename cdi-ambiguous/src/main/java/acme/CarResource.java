package acme;

import javax.annotation.Priority;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

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
