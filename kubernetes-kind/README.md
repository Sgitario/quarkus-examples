# Instructions

1. Set Up a local [Kind](https://kind.sigs.k8s.io/docs/user/quick-start/) cluster 
2. Install the example: `mvn clean install -Dquarkus.kubernetes.deploy=true -Dquarkus.kubernetes.namespace=default`