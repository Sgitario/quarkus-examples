package org.sgitario.quarkus.kafka;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class Service {

    public List<Output> processInputs(List<Input> inputs) {
        return inputs.stream()
                .map(input -> new Output(input, "HIGH_CAPACITY_" + input.getId()))
                .toList();
    }
}
