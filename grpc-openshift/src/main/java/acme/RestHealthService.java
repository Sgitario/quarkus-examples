package acme;

import io.quarkus.grpc.GrpcClient;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class RestHealthService {

    @GrpcClient
    HealthService health;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> hello() {
        return health.check(HealthCheckRequest.newBuilder().setService("aaa").build()).onItem().transform(r -> r.getStatus().name());
    }
}
