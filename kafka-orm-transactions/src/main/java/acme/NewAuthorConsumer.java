package acme;

import io.quarkus.logging.Log;
import io.smallrye.mutiny.Uni;
import io.smallrye.reactive.messaging.kafka.transactions.KafkaTransactions;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;

/**
 * Approach 1: Using MutinyEmitter
 */
/*@ApplicationScoped
public class NewAuthorConsumer {

    @Channel("new-book-out") MutinyEmitter<String> newBook;

    @Transactional
    @Incoming("new-author-in")
    void consume(String authorName) {
        Log.infof("Received new message in authors topic with name `{}`", authorName);
        Author author = new Author();
        author.name = authorName;
        author.persist();
        newBook.sendAndAwait(authorName + "-book1");
        newBook.sendAndAwait(authorName + "-book2");
    }
}*/

/**
 * Approach 2: Using Emitter
 */
/*@ApplicationScoped
public class NewAuthorConsumer {

    @Channel("new-book-out") Emitter<String> newBook;

    @Transactional
    @Incoming("new-author-in")
    CompletionStage<Void> consume(String authorName) {
        Log.infof("Received new message in authors topic with name `{}`", authorName);
        Author author = new Author();
        author.name = authorName;
        author.persist();
        return newBook.send(authorName + "-book1");
    }
}*/

/**
 * Approach 3: Using KafkaTransactions
 */
@ApplicationScoped
public class NewAuthorConsumer {

    @Channel("new-book-out") KafkaTransactions<String> kafkaTx;

    @Transactional
    @Incoming("new-author-in")
    Uni<Void> consume(String message) {
        Log.infov("Received new message in authors topic with name `{0}`", message);
        return kafkaTx.withTransaction(emitter -> {
            persistAuthor(message);
            emitter.send(message + "-book1");
            return Uni.createFrom().voidItem();
        });
    }

    private void persistAuthor(String name) {
        Author author = new Author();
        author.name = name;
        author.persist();
    }
}
