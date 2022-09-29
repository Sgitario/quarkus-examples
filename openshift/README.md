# Instructions

1. Log Into an OpenShift cluster
2. Install the example: `mvn clean install -DskipTests -Dquarkus.kubernetes.deploy=true`
3. `curl $(oc get route openshift -o jsonpath='{.spec.host}')/greetings`