# Instructions

For Dev:

1. `mvn quarkus:dev`
2. `curl http://localhost:8080/hello`

grpc-curl --json -d "{""getStatus"":{}}" http://localhost:9000 HealthService.Check

For OpenShift:

1. Log Into an OpenShift cluster
2. Install the example: `mvn clean install -DskipTests -Dquarkus.kubernetes.deploy=true`
3. `curl $(oc get route openshift -o jsonpath='{.spec.host}')/greetings`

For Native:

1. Log Into an OpenShift cluster
2. Install the example: `mvn clean install -DskipTests -Dquarkus.kubernetes.deploy=true -Dnative`
3. `curl $(oc get route openshift -o jsonpath='{.spec.host}')/greetings`