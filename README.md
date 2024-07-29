# E2E_selenium

This project contains functional tests for verifying the functionality of the site [https://demoqa.com/books](https://demoqa.com/books). The tests are executed using Maven.

## Table of Contents
- [Introduction](#introduction)
- [Project Structure](#project-structure)
- [Dependencies](#dependencies)
- [Setup](#setup)
- [Running the Tests](#running-the-tests)

## Introduction

This project aims to test simple functionalities of the Demo QA Book Store application.
This project serves as an example of how to organize Selenium WebDriver code using a well-structured framework. It demonstrates best practices for setting up a test automation framework with clear separation of concerns, reusable components, and integration with reporting and API testing tools. This framework can be adapted for various testing needs and is designed to be practical and easily extendable.


## Project Structure

```css
src
├── main
│   ├── java
│   │   └── org.ta_selenium
│   │           ├── interfaces  # ScrollAction Interface
│   │           ├── pages       # Page Object Models
│   │           └── utils       # API controller, Driver Factory, ReportManager,Scroll and Wait Utils
│   └── resources
├── test
│   ├── java
│   │   └── org.ta_selenium
│   │           ├── suites                     
│   │           └── tests       # Test classes
│   └── resources               # testng config file
└── pom.xml                     # Maven configuration file
```

## Dependencies
```css
<properties>
  <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  <selenium.version>4.14.1</selenium.version>
  <testng.version>7.8.0</testng.version>
  <extentreports.version>5.1.1</extentreports.version>
  <webdrivermanager.version>5.5.3</webdrivermanager.version>
  <rest-assured.version>5.5.0</rest-assured.version>
</properties>

```
`*` Selenium: For browser automation.

`*` TestNG: A testing framework inspired by JUnit and NUnit.

`*` ExtentReports: For generating detailed test reports

`*` WebDriverManager: Manages browser driver binaries.

`*` Rest-Assured: Simplifies API testing

## Prerequisites

Before you can build and run the tests, you need to have the following installed:

- [Maven](https://maven.apache.org/install.html)
- [Java JDK](https://aws.amazon.com/corretto/?filtered-posts.sort-by=item.additionalFields.createdDate&filtered-posts.sort-order=desc)

## Setup

1. Clone the repository to your local machine:

    ```sh
    git clone https://github.com/GiancarloMartino/E2E_selenium.git
    cd E2E_selenium
    ```

2. Ensure Maven is installed by running:

    ```sh
    mvn -version
    ```
3. Ensure Java set up properly in your system's PATH

   ```sh
   java -version
   ```

## Running the Tests

To execute the tests, navigate to the project's root directory and run:

```sh
mvn clean test
```