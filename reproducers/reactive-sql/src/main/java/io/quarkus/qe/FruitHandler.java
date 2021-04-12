package io.quarkus.qe;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.quarkus.vertx.web.Body;
import io.quarkus.vertx.web.Route;
import io.quarkus.vertx.web.Route.HttpMethod;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;
import io.vertx.pgclient.PgException;

@Singleton
public class FruitHandler {

    @Inject
    FruitResource fruitResource;

    @Route(methods = HttpMethod.POST, path = "/insert")
    void insert(@Body Fruit fruit, RoutingContext context) {
        fruitResource.insertFruit(fruit)
                .onFailure().invoke(context::fail)
                .subscribe().with(id -> context.response().setStatusCode(201).end());
    }

    @Route(path = "/*", type = Route.HandlerType.FAILURE, produces = "application/json")
    void databaseConstraintFailure(PgException e, HttpServerResponse response) {
        response.setStatusCode(400).end();
    }

}
