package acme.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("/files")
public class Resource {
    private static final File TXT_FILE = new File("./src/main/resources/lorem.txt");

    @GET
    @Path("/file")
    public File getFile() {
        return TXT_FILE;
    }

    @GET
    @Path("/input-stream")
    public InputStream getInputStream() throws FileNotFoundException {
        return new FileInputStream(TXT_FILE);
    }
}
