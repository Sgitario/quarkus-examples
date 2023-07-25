package acme.files;

import java.io.File;
import java.io.InputStream;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/files")
public interface Client {
    @GET
    @Path("/file")
    File getFile();

    @GET
    @Path("/input-stream")
    InputStream getInputStream();
}
