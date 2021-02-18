package io.quarkus.qe;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/rest-query")
public class QueryResource {
    @GET
    public Greeting getGreetingWithName(@Pattern(regexp = "ne.*") @NotNull @QueryParam("name") String name) {
        return new Greeting(name, "hi");
    }
}
