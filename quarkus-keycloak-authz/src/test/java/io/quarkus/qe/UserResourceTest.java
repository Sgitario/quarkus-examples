package io.quarkus.qe;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.Collections;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.impl.client.HttpClients;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.keycloak.authorization.client.AuthzClient;
import org.keycloak.authorization.client.Configuration;

import io.quarkus.qe.containers.KeycloakQuarkusTestResource;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@QuarkusTestResource(KeycloakQuarkusTestResource.class)
public class UserResourceTest {

    private static final String OIDC_AUTH_SERVER = "http://localhost:8180/auth/realms/test-realm";

    private AuthzClient authzClient;

    @BeforeEach
    public void setup() {
        authzClient = AuthzClient.create(new Configuration(
                StringUtils.substringBefore(OIDC_AUTH_SERVER, "/realms"),
                "test-realm",
                "test-application-client",
                Collections.singletonMap("secret", "test-application-client-secret"),
                HttpClients.createDefault()));
    }

    @Test
    public void normalUser_userResource() {
        given()
                .when()
                .auth().oauth2(getToken("test-normal-user", "test-normal-user"))
                .get("/user")
                .then()
                .statusCode(200)
                .body(equalTo("Hello, user test-normal-user"));
    }

    @Test
    public void normalUser_userResource_issuer() {
        given()
                .when()
                .auth().oauth2(getToken("test-normal-user", "test-normal-user"))
                .get("/user/issuer")
                .then()
                .statusCode(200)
                .body(equalTo("user token issued by " + OIDC_AUTH_SERVER));
    }

    @Test
    public void adminUser_userResource() {
        given()
                .when()
                .auth().oauth2(getToken("test-admin-user", "test-admin-user"))
                .get("/user")
                .then()
                .statusCode(200)
                .body(equalTo("Hello, user test-admin-user"));
    }

    @Test
    public void noUser_userResource() {
        given()
                .when()
                .get("/user")
                .then()
                .statusCode(401);
    }

    private String getToken(String userName, String password) {
        return authzClient.obtainAccessToken(userName, password).getToken();
    }
}
