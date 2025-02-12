package acme;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class NewBookConsumer {

    @Transactional
    @Incoming("new-book-in")
    void consume(String title) {
        Log.infov("Received new message in books topic with title `{0}`", title);
        Book book = new Book();
        book.title = title;
        book.persist();
    }
}
