package acme;

import java.io.IOException;
import java.nio.file.Files;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
