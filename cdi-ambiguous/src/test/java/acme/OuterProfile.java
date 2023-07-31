package acme;

import java.util.Collections;
import java.util.Map;

import io.quarkus.test.junit.QuarkusTestProfile;

public class OuterProfile implements QuarkusTestProfile {

    private static final int TEST_PORT_FROM_PROFILE = 7777;

    @Override
    public Map<String, String> getConfigOverrides() {
        return Collections.singletonMap("quarkus.http.test-port", "" + TEST_PORT_FROM_PROFILE);
    }

    @Override
    public String[] commandLineParameters() {
        return new String[] { "OuterProfile" };
    }

    @Override
    public boolean runMainMethod() {
        return true;
    }
}