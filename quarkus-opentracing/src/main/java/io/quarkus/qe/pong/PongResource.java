package io.quarkus.qe.pong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logmanager.MDC;

@Path("/pong")
public class PongResource {

    private String lastTraceId;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getPong() {
        lastTraceId = MDC.get("traceId");
        return "pong";
    }

    @GET
    @Path("/lastTraceId")
    @Produces(MediaType.TEXT_PLAIN)
    public String getLastTraceId() {
        return lastTraceId;
    }
}