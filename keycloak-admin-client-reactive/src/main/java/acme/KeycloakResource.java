package acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import org.keycloak.admin.client.Keycloak;

@Path("/hello")
public class KeycloakResource {

    @Inject
    Keycloak keycloak;

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public void deletePermission() {
        var clientResource = keycloak.realm("quarkus")
                .clients().get("0ac5df91-e044-4051-bd03-106a3a5fb9cc");
        clientResource.authorization()
                .permissions().resource().findById("3479dd56-02e9-4222-94fe-6a13cd065195").remove();
    }
}
