# Instructions

1. Set Up a local [Kind](https://kind.sigs.k8s.io/docs/user/quick-start/) cluster 
2. Install the example: `mvn clean install -DskipTests -Dquarkus.kubernetes.deploy=true -Dquarkus.kubernetes.namespace=default`
3. `kubectl exec -it $(kubectl get pods -l app.kubernetes.io/name=kubernetes-kind -o name) -- curl localhost:8080/greetings`