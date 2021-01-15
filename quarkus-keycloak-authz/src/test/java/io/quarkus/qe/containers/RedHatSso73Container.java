package io.quarkus.qe.containers;

import org.testcontainers.containers.BindMode;
import org.testcontainers.containers.GenericContainer;

public class RedHatSso73Container extends GenericContainer<RedHatSso73Container> {
    private static final String SSO_IMAGE = "registry.access.redhat.com/redhat-sso-7/sso73-openshift";
    private static final int FIXED_PORT = 8180;
    private static final String USER = "admin";
    private static final String PASSWORD = "admin";

    private static final String REALM_FILE = "/tmp/realm.json";

    public RedHatSso73Container() {
        super(SSO_IMAGE);
        addFixedExposedPort(FIXED_PORT, 8080);
        withEnv("SSO_ADMIN_USERNAME", USER);
        withEnv("SSO_ADMIN_PASSWORD", PASSWORD);
        withEnv("SSO_IMPORT_FILE", REALM_FILE);
        withClasspathResourceMapping("keycloak-realm.json", REALM_FILE, BindMode.READ_ONLY);
    }
}
