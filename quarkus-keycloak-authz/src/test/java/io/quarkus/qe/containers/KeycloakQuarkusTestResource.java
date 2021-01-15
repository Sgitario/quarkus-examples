package io.quarkus.qe.containers;

import java.time.Duration;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import org.testcontainers.containers.BindMode;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

public class KeycloakQuarkusTestResource implements QuarkusTestResourceLifecycleManager {

    private static final String USER = "admin";
    private static final String PASSWORD = "admin";

    private static final String REALM_FILE = "/tmp/realm.json";

    private GenericContainer<?> container;

    @SuppressWarnings("resource")
    @Override
    public Map<String, String> start() {

        container = new KeycloakContainer()
                .withEnv("KEYCLOAK_USER", USER)
                .withEnv("KEYCLOAK_PASSWORD", PASSWORD)
                .withEnv("KEYCLOAK_IMPORT", REALM_FILE)
                .withClasspathResourceMapping("keycloak-realm.json", REALM_FILE, BindMode.READ_ONLY)
                .waitingFor(Wait.forHttp("/auth").withStartupTimeout(Duration.ofMinutes(5)));
        container.start();

        return Collections.emptyMap();
    }

    @Override
    public void stop() {
        Optional.ofNullable(container).ifPresent(GenericContainer::stop);
    }
}
