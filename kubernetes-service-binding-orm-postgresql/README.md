# Instructions

1. Set Up a local [Kind](https://kind.sigs.k8s.io/docs/user/quick-start/) cluster
2. Install Postgresql using Helm: 

```
helm repo add bitnami https://charts.bitnami.com/bitnami
helm install postgresql bitnami/postgresql --version 11.9.1 --set auth.username=superman --set auth.password=superman --set auth.database=db
```

3. Install the example: `mvn clean install -DskipTests -Dquarkus.kubernetes.deploy=true -Dquarkus.kubernetes.namespace=default`
4. `kubectl exec -it $(kubectl get pods -l app.kubernetes.io/name=kubernetes-service-binding-orm-postgresql -o name) -- curl localhost:8080/fruits`