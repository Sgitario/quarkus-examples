package io.quarkus.qe.ping;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logmanager.MDC;

@Path("/ping")
public class PingResource {

    private String lastTraceId;

    @Inject
    @RestClient
    PongClient pongClient;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getPing(@Context HttpHeaders headers) {
        lastTraceId = MDC.get("traceId");

        return "ping " + pongClient.getPong();
    }

    @GET
    @Path("/lastTraceId")
    @Produces(MediaType.TEXT_PLAIN)
    public String getLastTraceId() {
        return lastTraceId;
    }
}