package acme;

import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.openshift.client.OpenShiftClient;
import io.quarkus.kubernetes.spi.KubernetesDeploymentClusterBuildItem;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/client")
public class KubernetesClientResource {
    @Inject
    KubernetesClient client;

    @GET
    @Path("/namespace")
    public String getNamespace() {
        return client.getNamespace();
    }

    @GET
    @Path("/pods/count")
    public int getPodsCount() {
        return client.pods().list().getItems().size();
    }

    @GET
    @Path("/check/openshift")
    public boolean checkOpenShift() {
        try (var openShiftClient = client.adapt(OpenShiftClient.class)) {
            return openShiftClient.isSupported();
        } catch (Exception e) {
            return false;
        }
    }
}
