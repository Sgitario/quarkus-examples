package acme;

import org.junit.jupiter.api.Test;

import io.github.snowdrop.jester.api.Jester;
import io.github.snowdrop.jester.api.Quarkus;

@Jester
@Quarkus(forceBuild = true)
public class MyClientIT {

    @Test
    public void shouldPassPathParamsToSubResource() {
        // do nothing
    }
}
