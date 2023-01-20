package acme;

import java.io.File;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.reactive.PartType;
import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.multipart.FileUpload;

public class MultipartBody {

    @RestForm("text")
    @PartType(MediaType.TEXT_PLAIN)
    public String text;

    @RestForm("image")
    @PartType("image/png")
    public File image;

    @RestForm("data")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    public File data;

    @RestForm
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    public File plainTextFile;

    @RestForm("*")
    public List<FileUpload> allFiles;

}
