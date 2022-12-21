package acme;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

@Alternative
@Priority(100)
@ApplicationScoped
public class Ford implements Car {
    @Override
    public String model() {
        return "ford";
    }
}
