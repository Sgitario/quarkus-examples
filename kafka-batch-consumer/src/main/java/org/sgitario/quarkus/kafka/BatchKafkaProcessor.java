package org.sgitario.quarkus.kafka;

import io.smallrye.mutiny.Uni;
import io.smallrye.reactive.messaging.kafka.transactions.KafkaTransactions;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

import java.util.List;

@ApplicationScoped
public class BatchKafkaProcessor {

    private static final Logger LOGGER = Logger.getLogger(BatchKafkaProcessor.class);

    @Channel("processed-topic")
    KafkaTransactions<String> producer;

    @Incoming("my-batch-topic")
    public Uni<Void> consume(List<String> messages) {
        LOGGER.infof("Received %d messages", messages.size());

        List<String> processed = messages.stream()
            .map(msg -> "[Processed] " + msg)
            .toList();

        // Using: https://quarkus.io/guides/kafka#kafka-transactions
        return producer.withTransaction(emitter -> {
            processed.forEach(emitter::send);
            return Uni.createFrom().voidItem();
        });
    }
}