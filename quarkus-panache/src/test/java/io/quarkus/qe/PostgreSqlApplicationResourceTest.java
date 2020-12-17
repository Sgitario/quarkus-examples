package io.quarkus.qe;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import io.quarkus.qe.containers.PostgreSqlDatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.QuarkusTestProfile;
import io.quarkus.test.junit.TestProfile;

@QuarkusTest
@TestProfile(PostgreSqlApplicationResourceTest.PostgresProfile.class)
public class PostgreSqlApplicationResourceTest extends BaseApplicationResourceTest {

    public static class PostgresProfile implements QuarkusTestProfile {
        @Override
        public String getConfigProfile() {
            return "postgresql";
        }

        @Override
        public List<TestResourceEntry> testResources() {
            return Collections.singletonList(new TestResourceEntry(PostgreSqlDatabaseTestResource.class));
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
