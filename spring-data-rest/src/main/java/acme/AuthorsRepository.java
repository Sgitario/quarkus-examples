package acme;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@DenyAll
public interface AuthorsRepository extends CrudRepository<Author, Long> {

    @PermitAll
    @Override
    Iterable<Author> findAll();

    @RolesAllowed("superuser")
    @RestResource(exported = false)
    <S extends Author> S save(S author);

    @RestResource(exported = false)
    void deleteById(Long id);
}
