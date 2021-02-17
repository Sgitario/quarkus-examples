package io.quarkus.qe;

import javax.enterprise.context.RequestScoped;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@RequestScoped
public class GreetingService {

    @ConfigProperty(name = "my.property")
    String property;

    public String getProperty() {
        return property;
    }
}
