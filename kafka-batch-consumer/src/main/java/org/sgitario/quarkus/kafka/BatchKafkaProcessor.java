package org.sgitario.quarkus.kafka;

import io.smallrye.mutiny.Uni;
import io.smallrye.reactive.messaging.annotations.Blocking;
import io.smallrye.reactive.messaging.kafka.transactions.KafkaTransactions;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

import java.util.List;

@ApplicationScoped
public class BatchKafkaProcessor {

    private static final Logger LOGGER = Logger.getLogger(BatchKafkaProcessor.class);

    @Inject
    Service service;

    @Channel("processed-topic")
    KafkaTransactions<Output> producer;

    @Blocking
    @Incoming("my-batch-topic")
    public Uni<Void> consume(List<Input> messages) {
        LOGGER.infof("Received %d input messages", messages.size());
        List<Output> processed = service.processInputs(messages);
        LOGGER.infof("Processed %d outputs", processed.size());

        // Using: https://quarkus.io/guides/kafka#kafka-transactions
        return producer.withTransaction(emitter -> {
            processed.forEach(emitter::send);
            return Uni.createFrom().voidItem();
        });
    }
}