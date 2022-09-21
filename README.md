# Quarkus Examples

Some examples that are used to debug Quarkus extensions by using:
* The `quarkus.package.fernflower.enabled=true` property to see the generated sources by Quarkus.
* The `-deployment` versions of the Quarkus extensions, so we can debug the build steps done by the Quarkus processors (this is possible thank to the `Jester` testing framework).

## Prerequisites
* JDK 11
* Maven 3.6+
* Jester:
```
  git clone https://github.com/Sgitario/jester/
  cd jester
  mvn clean install -Pframework -DskipTests
```

## Build

```
mvn clean install
```