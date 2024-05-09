package acme;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Optional;

@RepositoryRestResource(exported = false, path = "secret", collectionResourceRel = "secret-records")
public interface CalendarRepository extends JpaRepository<Calendar, Long> {
    @Override
    @RestResource(path = "records")
    Optional<Calendar> findById(Long id);

    @Override
    @RestResource(rel = "list", path = "records")
    Page<Calendar> findAll(Pageable pageable);
}
