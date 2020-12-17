package io.quarkus.qe;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.QuarkusTestProfile;
import io.quarkus.test.junit.TestProfile;

@QuarkusTest
@TestProfile(H2ApplicationResourceTest.H2Profile.class)
public class H2ApplicationResourceTest extends BaseApplicationResourceTest {

    public static class H2Profile implements QuarkusTestProfile {
        @Override
        public String getConfigProfile() {
            return "h2";
        }

        @Override
        public List<TestResourceEntry> testResources() {
            return Collections.singletonList(new TestResourceEntry(H2DatabaseTestResource.class));
        }
    }

    @Inject
    ApplicationService service;

    @Test
    public void testService() {
        givenApplicationWithServices("servicea", "serviceb");
        assertTrue(!service.getList(0, 10).isEmpty());
    }
}
