package acme;

import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Alternative;

@Alternative
@Priority(100)
@ApplicationScoped
public class Ford implements Car {
    @Override
    public String model() {
        return "ford";
    }
}
