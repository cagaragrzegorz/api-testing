# API test based on Groovy and Spock

* [Requirements](#requirements)
* [Tech stack](#tech-stack)
* [Build and run tests](#build-and-run-tests)
* [Test report](#test-report)

## Requirements

* Java JDK 21

## Tech stack

* Gradle
* Groovy
* Spock
* RestAssured


## Build and run tests

1. Download/clone the project
2. Run following commands to build and run tests

Linux / MacOS

```
./gradlew clean build test
```

3. Run tests from IDE. Tests are located under

```
../src/test/groovy/com/cagara/postmanApi/*Test.groovy
```
## Test report

Test report will be generated and available under:

```
../spock-reports/index.html
```