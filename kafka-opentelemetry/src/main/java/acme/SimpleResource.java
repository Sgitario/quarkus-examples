package acme;

import io.opentelemetry.api.trace.Span;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.jboss.logging.Logger;

@Path("")
@Produces(MediaType.APPLICATION_JSON)
public class SimpleResource {

    private static final Logger LOG = Logger.getLogger(SimpleResource.class);

    @Channel("traces-out")
    Emitter<String> emitter;

    @GET
    @Path("/ping")
    public void ping() {
        LOG.info("ping: " + Span.current().getSpanContext().getTraceId());
        emitter.send(Message.of("ping"));
    }

}
