package acme;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import java.util.concurrent.CompletionStage;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;

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

//
//    @Transactional
//    @Incoming("new-book-in")
//    CompletionStage<Void> consume(Message<String> msg) {
//        String title = msg.getPayload();
//        Log.infov("Received new message in books topic with title `{0}`", title);
//        if (title.equals("Jack-book1")) {
//            return msg.nack(new IllegalStateException("Hello World"));
//        }
//        Book book = new Book();
//        book.title = title;
//        book.persist();
//        return msg.ack();
//    }
}
