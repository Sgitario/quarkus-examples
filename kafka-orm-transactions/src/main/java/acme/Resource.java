package acme;

import java.util.List;
import io.smallrye.reactive.messaging.MutinyEmitter;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.jboss.resteasy.reactive.RestPath;

@Path("/api")
public class Resource {

    @Channel("new-author-out")
    MutinyEmitter<String> newAuthor;

    @Transactional
    @GET
    @Path("/authors")
    public List<Author> authors() {
        return Author.listAll();
    }

    @Transactional
    @GET
    @Path("/books")
    public List<Book> books() {
        return Book.listAll();
    }

    @Transactional
    @POST
    @Path("/authors/{name}")
    public void submitAuthor(@RestPath String name) {
        newAuthor.sendAndAwait(name);
    }
}
