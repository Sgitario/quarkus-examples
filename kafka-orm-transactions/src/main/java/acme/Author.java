package acme;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;

@Entity
public class Author extends PanacheEntityBase {
    @Id
    public String name;

    public String getName() {
        return name;
    }
}
