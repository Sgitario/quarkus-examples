package acme;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import io.quarkus.hibernate.reactive.rest.data.panache.PanacheEntityResource;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import io.quarkus.rest.data.panache.MethodProperties;
import io.quarkus.rest.data.panache.ResourceProperties;
import io.quarkus.rest.data.panache.RestDataPanacheException;
import io.smallrye.mutiny.Uni;

@ResourceProperties(exposed = true)
public interface AuthorsResource extends PanacheEntityResource<Author, Long> {

    /* Uni<Author> update() {
        Author author = new Author();

        Uni<Author> var6 = Author.getSession()
                .flatMap(s -> s.merge(author))
                .onFailure().invoke(ex -> new RestDataPanacheException("Failed to retrieve session", ex))
                .onItem().invoke(a -> a.toString());
    } */
}
