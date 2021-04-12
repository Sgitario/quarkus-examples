package io.quarkus.qe;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.sqlclient.Row;
import io.vertx.mutiny.sqlclient.RowSet;
import io.vertx.mutiny.sqlclient.SqlClient;
import io.vertx.mutiny.sqlclient.SqlClientHelper;
import io.vertx.mutiny.sqlclient.Tuple;

@ApplicationScoped
public class FruitResource {

    @Inject
    io.vertx.mutiny.pgclient.PgPool client;

    public Uni<Void> insertTwoFruits(Fruit fruit1, Fruit fruit2) {
        return SqlClientHelper.inTransactionUni(client, tx -> {
            Uni<RowSet<Row>> insertOne = tx.preparedQuery("INSERT INTO fruits (name) VALUES ($1)")
                    .execute(Tuple.of(fruit1.name));
            Uni<RowSet<Row>> insertTwo = tx.preparedQuery("INSERT INTO fruits (name) VALUES ($1)")
                    .execute(Tuple.of(fruit2.name));

            return insertOne.and(insertTwo)
                    // Ignore the results (the two ids)
                    .onItem().ignore().andContinueWithNull();
        });
    }

    public Uni<Void> insertFruit(Fruit fruit) {
        return SqlClientHelper.inTransactionUni(client, tx -> insertTwoFruit(fruit, tx));
    }

    private Uni<Void> insertTwoFruit(Fruit fruit, SqlClient tx) {
        Uni<RowSet<Row>> insertOne = tx.preparedQuery("INSERT INTO amadeus.fruits (name) VALUES ($1)")
                .execute(Tuple.of(fruit.name));

        return insertOne.onItem().ignore().andContinueWithNull();
    }
}
