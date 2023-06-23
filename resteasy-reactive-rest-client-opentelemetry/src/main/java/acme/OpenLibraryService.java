package acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("/search.json")
public interface OpenLibraryService {

    @GET
    String search(@QueryParam("q") String query);
}
