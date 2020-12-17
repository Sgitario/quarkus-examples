package io.quarkus.qe;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ApplicationRepository implements PanacheRepository<ApplicationEntity> {

}
