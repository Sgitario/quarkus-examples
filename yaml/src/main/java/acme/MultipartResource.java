package acme;

import java.io.IOException;
import java.nio.file.Files;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/multipart")
public class MultipartResource {

    @POST
    @Path("/plain-text-file")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public String postFormReturnPlainTextFile(MultipartBody multipartBody) throws IOException {
        return Files.readString(multipartBody.plainTextFile.toPath());
    }
}
