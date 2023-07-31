package acme;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;

@QuarkusTest
@TestProfile(OuterProfile.class)
public class Nested1WithCommonTest extends CommonNestedTest {

    @Override
    public String defaultProfile() {
        return "OuterProfile";
    }
}
