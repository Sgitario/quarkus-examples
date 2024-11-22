package acme;

import java.util.List;

import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import io.quarkus.rest.data.panache.MethodProperties;
import io.quarkus.rest.data.panache.ResourceProperties;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

// @UnlessBuildProperty(name = "foo.enabled", stringValue = "false")
@ResourceProperties(hal = true)
public interface AuthorsResource extends PanacheEntityResource<Author, Long> {

    @MethodProperties
    List<Author> list(Page page, Sort sort);

    @MethodProperties
    Author get(Long id);

    @Transactional
    @POST
    @Path("/name/{name}")
    @Consumes
    @Produces("application/json")
    default Author addByName(@PathParam("name") String name) {
        Author author = new Author();
        author.name = name;
        Author.persist(author);
        return author;
    }
}
