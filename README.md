## A Simple Graph & Lattice Implementation

A very simple graph and lattice implementation. Most of the documentation is in the code, although a bit sparse.

## Pre-requisites
 * You need JRE installed wherever you want to run this
 * Minimum JRE version = 13 | Recommended Python version = 21
 * You need gradle installed
   * Note: For MacOS, if you have Homebrew installed (see how), a simple brew install openjdk gradle should do the trick.
     * For Ubuntu: See this.
     * For other OSes, use this.

## Running
 * Ensure pre-requisites (above).
 * Check out the repository.
 * Issue: ./gradlew run on the command line from the project root (HundredPrisoners/).
   * Note: For Windows, issue: gradlew.bat run from the project root.

## Developing
 * The `build.gradle` file at project root enables these commands:  
   * `./gradlew clean`
   * `./gradlew build`
   * `./gradlew run`
 * Code coverage should be at least 50% overall, for a report, use this:
   * `./gradlew test jacocoTestReport`
   * An HTML report is available locally at project root here:
     * `build/reports/jacoco/test/html/index.html`
 * To run the tests (only), run this:
   * `./gradlew test`
