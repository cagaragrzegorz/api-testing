# API test based on Java and Cucumber

* [Requirements](#requirements)
* [Tech stack](#tech-stack)
* [Build and run tests](#build-and-run-tests)
* [Test report](#test-report)

## Requirements

* Java JDK 21

## Tech stack

* Java
* Cucumber
* RestAssured
* Maven

## Build and run tests

1. Download/clone the project
2. Run following commands to build and run tests

Linux / MacOS

```
./mvnw clean test -Dtest="SampleApiTests" 
```

3. Run tests from IDE. Features with scenarios are located under:

```
...src/test/java/com/cagara/postmanApi/features/*.feature
```
Tests with configuration are located under:
```
...src/test/java/com/cagara/postmanApi/tests/*Tests.java
```
## Test report

HTML test report will be generated and available under:

```
...target/cucumberhtml-reports.html
```
JUnit xml will be generated and available under:
```
...target/surefire-reports/TEST-*.xml
```