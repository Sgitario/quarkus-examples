package io.quarkus.qe.containers;

import org.testcontainers.containers.BindMode;
import org.testcontainers.containers.GenericContainer;

public class RedHatSso74Container extends GenericContainer<RedHatSso74Container> {
    private static final String SSO_IMAGE = "registry.redhat.io/rh-sso-7/sso74-openshift-rhel8";
    private static final int FIXED_PORT = 8180;
    private static final String USER = "admin";
    private static final String PASSWORD = "admin";

    private static final String REALM_FILE = "/tmp/realm.json";

    public RedHatSso74Container() {
        super(SSO_IMAGE);
        addFixedExposedPort(FIXED_PORT, 8080);
        withEnv("SSO_ADMIN_USERNAME", USER);
        withEnv("SSO_ADMIN_PASSWORD", PASSWORD);
        withEnv("SSO_IMPORT_FILE", REALM_FILE);
        withClasspathResourceMapping("keycloak-realm.json", REALM_FILE, BindMode.READ_ONLY);
    }
}
