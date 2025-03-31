package acme;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("/queries")
public class QueryResource {
  @GET
  public String get(@DefaultValue("default") @QueryParam("value") String value) {
    return "Value was: " + value;
  }
}
