package acme;

import java.time.LocalDate;

import jakarta.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;

@Entity
public class Author extends PanacheEntity {

    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    public String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public LocalDate dob;

    public void doSomething() {
        System.out.println("sasd");
    }
}
