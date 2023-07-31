package acme;

import io.quarkus.arc.properties.UnlessBuildProperty;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheRepositoryResource;
import io.quarkus.rest.data.panache.ResourceProperties;

@UnlessBuildProperty(name = "foo.enabled", stringValue = "false")
@ResourceProperties(hal = true)
public interface BooksResource extends PanacheRepositoryResource<BookRepository, Book, Long> {
}
