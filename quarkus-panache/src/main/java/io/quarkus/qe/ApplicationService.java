package io.quarkus.qe;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ApplicationService {
    @Inject
    ApplicationRepository repository;

    public List<ApplicationEntity> getList(int page, int totalNumber) {
        return repository.findAll().page(page, totalNumber).list();
    }
}
