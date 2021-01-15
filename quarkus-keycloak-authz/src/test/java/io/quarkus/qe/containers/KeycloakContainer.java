package io.quarkus.qe.containers;

import org.testcontainers.containers.GenericContainer;

public class KeycloakContainer extends GenericContainer<KeycloakContainer> {
    private static final String KEYCLOAK_IMAGE = "quay.io/keycloak/keycloak:11.0.3";
    private static final int FIXED_PORT = 8180;

    public KeycloakContainer() {
        super(KEYCLOAK_IMAGE);
        addFixedExposedPort(FIXED_PORT, 8080);
    }
}
