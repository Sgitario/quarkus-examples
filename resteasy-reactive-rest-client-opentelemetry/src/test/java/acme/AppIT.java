package acme;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import io.github.snowdrop.jester.api.Jester;
import io.github.snowdrop.jester.api.Quarkus;

@Jester
@Quarkus(forceBuild = true)
public class AppIT {
    @Test
    public void test() {
        assertTrue(true);
    }
}
