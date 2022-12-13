package acme;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class KeycloakClientTest {

    Keycloak keycloak;

    @BeforeEach
    void setup() {
        keycloak = KeycloakBuilder.builder()
                .serverUrl("http://localhost:8181")
                .realm("master")
                .clientId("admin-cli")
                .grantType("password")
                .username("admin")
                .password("admin")
                .build();
    }

    @AfterEach
    void teardown() {
        keycloak.close();
    }

    @Test
    void testDeletePermission() {
        var clientResource = keycloak.realm("quarkus")
                .clients().get("0ac5df91-e044-4051-bd03-106a3a5fb9cc");
        clientResource.authorization()
                .permissions().resource().findById("3479dd56-02e9-4222-94fe-6a13cd065195").remove();
    }
}
