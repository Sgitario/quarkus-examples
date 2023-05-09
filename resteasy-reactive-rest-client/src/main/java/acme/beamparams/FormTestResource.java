package acme.beamparams;

import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/form")
public class FormTestResource {
    @POST
    public String post(@FormParam("param1") String param1, @FormParam("param2") String param2,
            @FormParam("param3") String param3) {
        return String.format("received %s-%s-%s", param1, param2, param3);
    }
}
