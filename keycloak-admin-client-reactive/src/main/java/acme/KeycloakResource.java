package acme;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
