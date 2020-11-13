package io.quarkus.qe.traceable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logmanager.MDC;

public abstract class TraceableResource {

    private String lastTraceId;

    @GET
    @Path("/lastTraceId")
    @Produces(MediaType.TEXT_PLAIN)
    public String getLastTraceId() {
        return lastTraceId;
    }

    protected void recordTraceId() {
        lastTraceId = MDC.get("traceId");
    }
}