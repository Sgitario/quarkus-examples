package io.quarkus.qe.containers;

import java.time.Duration;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

public class AuthProviderQuarkusTestResource implements QuarkusTestResourceLifecycleManager {

    private GenericContainer<?> container;

    @Override
    public Map<String, String> start() {

        // container = new KeycloakContainer();
        container = new RedHatSso74Container();
        // container = new RedHatSso73Container();
        container.waitingFor(Wait.forHttp("/auth").withStartupTimeout(Duration.ofMinutes(5)));
        container.start();

        return Collections.emptyMap();
    }

    @Override
    public void stop() {
        Optional.ofNullable(container).ifPresent(GenericContainer::stop);
    }
}
