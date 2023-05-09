package acme.beamparams;

import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("/form")
public interface FormTestClient {
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    String postFormParams(@BeanParam BeanWithFormParams beanParam);
}
