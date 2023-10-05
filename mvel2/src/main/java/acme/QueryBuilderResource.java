package acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.mvel2.templates.TemplateRuntime;

import java.util.HashMap;
import java.util.Map;

@Path("/mvel2")
public class QueryBuilderResource {
    @GET
    public String buildQuery() {
        String templateKey = "default";
        String template =
                "Account: @{runtime['account']} Metric ID: @{metric.id} P1: @{metric.prometheus.queryParams['metadataMetric']}";

        String id = "Cores";
        String account = "12345";
        String param1 = "ocm_subscription";

        MetricProperties props = new MetricProperties();
        props.getQueryTemplates().put(templateKey, template);

        Map<String, String> params = new HashMap<>();
        params.put("metadataMetric", param1);

        Map<String, String> runtimeParams = new HashMap<>();
        runtimeParams.put("account", account);

        QueryDescriptor queryDesc = new QueryDescriptor(
                Metric.builder()
                        .id(id)
                        .prometheus(new PrometheusMetric("default", params))
                        .build(),
                runtimeParams);

        return (String) TemplateRuntime.eval(template, queryDesc);
    }
}
