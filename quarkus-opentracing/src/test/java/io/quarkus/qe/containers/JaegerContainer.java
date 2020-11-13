package io.quarkus.qe.containers;

import org.testcontainers.containers.GenericContainer;

public class JaegerContainer extends GenericContainer<JaegerContainer> {

    private static final int TRACE_PORT = 14268;
    private static final int REST_PORT = 16686;

    public JaegerContainer() {
        super("jaegertracing/all-in-one:latest");
        addFixedExposedPort(TRACE_PORT, TRACE_PORT);
        addFixedExposedPort(REST_PORT, REST_PORT);
    }
}
