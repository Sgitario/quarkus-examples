package acme;

import io.opentelemetry.api.trace.Span;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

@ApplicationScoped
public class TracedKafkaConsumer {
    private static final Logger LOG = Logger.getLogger(TracedKafkaConsumer.class);

    @Incoming("traces-in")
    void consume(String msg) {
        LOG.info(msg + ": " + Span.current().getSpanContext().getTraceId());
    }
}
