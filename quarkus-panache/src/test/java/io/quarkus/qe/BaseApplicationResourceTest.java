package io.quarkus.qe;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.ws.rs.core.MediaType;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public abstract class BaseApplicationResourceTest {

    private static final String APPLICATION_PATH = "/application";
    private static final String EXPECTED_VERSION = "1.2.0";

    private ApplicationEntity actualEntity;
    private ApplicationEntity[] actualList;

    @AfterEach
    public void tearDown() {
        deleteEntityIfExists();
    }

    @Test
    public void shouldCreateApplication() {
        whenCreateApplication("my-app-name");
        thenApplicationMatches("my-app-name");
    }

    @Test
    public void shouldUpdateApplication() {
        whenCreateApplication("my-app-name");
        whenUpdateApplication("another-app-name");
        thenApplicationMatches("another-app-name");
    }

    @Test
    public void shouldListApplications() {
        whenCreateApplication("my-app-name");
        whenGetApplications();
        thenApplicationsCountIs(1);
        thenApplicationsContainWithName("my-app-name");
    }

    @Test
    public void shouldDeleteApplication() {
        whenCreateApplication("my-app-name");
        whenDeleteApplication();
        whenGetApplications();
        thenApplicationsCountIs(0);
    }

    /**
     * This test is disabled because the conflict exception raised by hibernate validator is wrapping it up by the rollback
     * exception which ends up in a HTTP 500 Internal Server Error instead of a HTTP 409 Conflict.
     */
    @Disabled("Caused by https://github.com/quarkusio/quarkus/issues/13307.")
    @Test
    public void shouldReturnBadRequestIfApplicationNameIsNull() {
        applicationPath().body(new ApplicationEntity()).post()
                .then()
                .statusCode(HttpStatus.SC_CONFLICT);
    }

    @Test
    public void shouldFindApplicationWhenFilteringByName() {
        whenCreateApplication("my-app-name");
        whenFilterApplicationByName("useLikeByName", "name", "-app-");
        thenApplicationsCountIs(1);
    }

    @Test
    public void shouldNotFindApplicationWhenFilteringByName() {
        whenCreateApplication("my-app-name");
        whenFilterApplicationByName("useLikeByName", "name", "not-exist");
        thenApplicationsCountIs(0);
    }

    @Test
    public void shouldFindApplicationWhenFilteringByServiceName() {
        givenApplicationWithServices("service-a", "service-b");
        whenFilterApplicationByName("useServiceByName", "name", "service-a");
        thenApplicationsContainService("service-a");
        thenApplicationsDoNotContainService("service-b");
    }

    protected void givenApplicationWithServices(String... services) {
        whenCreateApplication("my-app-name");

        for (String service : services) {
            whenCreateService(service);
            thenServiceIsFound(service);
        }
    }

    private void whenCreateService(String serviceName) {
        ServiceEntity service = new ServiceEntity();
        service.setName(serviceName);
        actualEntity.getServices().add(service);
        applicationPath().body(actualEntity).put("/" + actualEntity.id)
                .then().statusCode(HttpStatus.SC_NO_CONTENT);
        whenGetApplication();
    }

    private void whenFilterApplicationByName(String filterName, String paramName, String paramValue) {
        String params = String.format("?%s=%s", paramName, paramValue);

        actualList = applicationPath().get("filterBy/" + filterName + params).then()
                .statusCode(HttpStatus.SC_OK).and().extract().as(ApplicationEntity[].class);
    }

    private void whenCreateApplication(String appName) {
        ApplicationEntity request = new ApplicationEntity();
        request.setName(appName);
        request.setVersion(new VersionEntity());
        request.getVersion().setId(EXPECTED_VERSION);

        actualEntity = applicationPath().body(request).post()
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .and().extract().as(ApplicationEntity.class);
    }

    private void whenUpdateApplication(String appName) {
        actualEntity.setName(appName);
        applicationPath().body(actualEntity).put("/" + actualEntity.id)
                .then().statusCode(HttpStatus.SC_NO_CONTENT);
    }

    private void whenDeleteApplication() {
        applicationPath().delete("/" + actualEntity.id)
                .then().statusCode(HttpStatus.SC_NO_CONTENT);

        actualEntity = null;
    }

    private void whenGetApplication() {
        actualEntity = applicationPath().get("/" + actualEntity.id).then().statusCode(HttpStatus.SC_OK).and().extract()
                .as(ApplicationEntity.class);
    }

    private void whenGetApplications() {
        actualList = applicationPath().get().then().statusCode(HttpStatus.SC_OK).and().extract().as(ApplicationEntity[].class);
    }

    private void thenApplicationMatches(String expectedAppName) {
        assertNotNull(actualEntity.id);
        assertEquals(expectedAppName, actualEntity.getName());
        assertEquals(EXPECTED_VERSION, actualEntity.getVersion().getId());
    }

    private void thenApplicationsCountIs(int expectedCount) {
        assertNotNull(actualList);
        assertEquals(expectedCount, actualList.length);
    }

    private void thenApplicationsContainWithName(String expectedAppName) {
        assertNotNull(actualList);
        assertTrue(Stream.of(actualList).allMatch(item -> expectedAppName.equals(item.getName())));
    }

    private void thenApplicationsContainService(String expectedServiceName) {
        thenApplicationsMatchServicesCondition(actualServices -> actualServices.contains(expectedServiceName));
    }

    private void thenApplicationsDoNotContainService(String expectedServiceName) {
        thenApplicationsMatchServicesCondition(actualServices -> !actualServices.contains(expectedServiceName));
    }

    private void thenApplicationsMatchServicesCondition(Predicate<List<String>> servicePredicate) {
        for (ApplicationEntity actualApplication : actualList) {
            List<String> actualServices = actualApplication.getServices().stream().map(s -> s.getName())
                    .collect(Collectors.toList());
            assertTrue(servicePredicate.test(actualServices), "Service not expected. Found: " + actualServices);
        }
    }

    private void thenServiceIsFound(String expectedServiceName) {
        assertNotNull(actualEntity.getServices());
        assertFalse(actualEntity.getServices().isEmpty(), "No services found");
        assertTrue(actualEntity.getServiceByName(expectedServiceName).isPresent());
    }

    private void deleteEntityIfExists() {
        if (actualEntity != null) {
            whenDeleteApplication();
        }
    }

    private static final RequestSpecification applicationPath() {
        return given().accept(MediaType.APPLICATION_JSON).contentType(ContentType.JSON).when().basePath(APPLICATION_PATH);
    }
}
