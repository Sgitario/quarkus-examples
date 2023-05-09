package acme;

import acme.HealthCheckRequest;
import acme.HealthCheckResponse;
import acme.HealthService;
import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

@GrpcService
public class GrpcHealthService implements HealthService {

    @Override
    public Uni<HealthCheckResponse> check(HealthCheckRequest request) {
        return Uni.createFrom().failure(new RuntimeException("Error!"));
    }

    @Override
    public Multi<HealthCheckResponse> watch(HealthCheckRequest request) {
        return Multi.createFrom().failure(new RuntimeException("Error!"));
    }
}