package io.quarkus.qe;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import io.quarkus.vertx.web.Param;
import io.quarkus.vertx.web.Route;
import io.smallrye.mutiny.Uni;
import io.vertx.core.http.HttpMethod;

@ApplicationScoped
public class MyRoutes {

    @Route(methods = HttpMethod.GET, path = "/valid")
    public Uni<Greeting> getValidGreeting() {
        return Uni.createFrom().item(new Greeting("luke", "hello"));
    }

    @Route(methods = HttpMethod.GET, path = "/invalid")
    @Valid
    public Uni<Greeting> getInvalidValidGreeting() {
        return Uni.createFrom().item(new Greeting("neo", "hello"));
    }

    @Route(methods = HttpMethod.GET, path = "/invalid2")
    public @Valid Uni<Greeting> getDoubleInValidGreeting() {
        return Uni.createFrom().item(new Greeting("neo", "hi"));
    }

    @Route(methods = HttpMethod.GET, path = "/vertx-query")
    public Uni<Greeting> getGreetingWithName(@Pattern(regexp = "ne.*") @NotNull @Param("name") String name) {
        return Uni.createFrom().item(new Greeting(name, "hi"));
    }

}