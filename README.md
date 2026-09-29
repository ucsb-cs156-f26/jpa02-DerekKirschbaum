# jpa02-DerekKirschbaum

Repo: https://github.com/ucsb-cs156-f26/jpa02-DerekKirschbaum

Deployed at: https://jpa02-derekkirschbaum.dokku-00.cs.ucsb.edu


# About this repo

This is a minimal "Hello World" type webapp built with Spring Boot.

# Java 25 setup with SDKMAN

This project follows the course instructions for Java 25.0.4, using the
recommended `25.0.4-tem` distribution via SDKMAN, with Maven 3.9.16
(also provided by the included Maven Wrapper, `./mvnw`).

If you use SDKMAN, the setup is:

```bash
sdk install java 25.0.4-tem
sdk install maven 3.9.16
sdk env install
java -version
mvn --version
```

The project includes a `.java-version` file and an `.sdkmanrc` file so that
the correct Java version is selected automatically when SDKMAN is present
(run `sdk env` in this directory to select it).  Every `mvn` command below
can also be run as `./mvnw`, which downloads and uses the pinned Maven
version without a separate Maven install.

# What can you do with this code?

| Command | What it does   |
|----------|---------------------------------------|
| `mvn compile` | Should result in a clean compile |
| `mvn test` | Runs JUnit tests on the code base |
| `mvn test jacoco:report` | Runs JUnit tests, and if all tests pass, computes code coverage.  The code coverage report (Jacoco) can be found in `target/site/jacoco/index.html` |
| `mvn test pitest:mutationCoverage` | Runs JUnit tests, and if all tests pass, runs pit (pitest.org) mutation testing to measure effectivness of test suite |
| `mvn package` | Builds the jar file `target/hello-1.1.0.jar` |
| `mvn spring-boot:run` | Runs the code to startup a web server.  Access it via `http://localhost:8080` on the *same machine* where the server is running.  Use CTRL/C to stop it. |
| `java -cp target/hello-1.1.0.jar edu.ucsb.cs156.spring.hello.Application` | If done after `mvn package`, runs the code to startup a web server.  |
| `java -jar target/hello-1.1.0.jar` | If done after `mvn package`, this is another way to start up the web server.|


# Sources

The code in this repo is in support of
jpa02 for f26 for CMPSC 156.

The code in this repo is based in part on the tutorial here:
<https://spring.io/guides/gs/spring-boot/>, and the code here in the
`complete` directory of this repo
<https://github.com/spring-guides/gs-spring-boot.git>.  

That code has been
modified for use in UCSB CMPSC 156 as described
below.

# Modifications from the original

* Java 25 support
  * Converting `pom.xml` to use Java 25
  * Updating Spring Boot (3.5.x), JaCoCo, and PIT (pitest) to versions that
    can read Java 25 class files
  * Adding `.java-version`, `.sdkmanrc`, and the Maven Wrapper (`mvnw`, Maven 3.9.16)
* JUnit 5
  * Converting test code to use JUnit 5 instead of JUnit 4  
* Dokku Support
  * Ensuring that the `PORT` environment variable is
    used to define the port on which Spring Boot starts the web server 
* Testing and CI
  * Adding JUnit tests
  * Adding jacoco as a plugin to measure test 
    case coverage
  * Adding pitest for mutation test coverage.
  * Adding support for GitHub Actions to run
    the test cases, compute jacoco report,
    upload code coverage reports to Codecov.io,
    and produce pitest artifacts.


