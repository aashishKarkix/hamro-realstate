# Hamro RealState

## Overview

Hamro RealState is a Java-based web application for managing real estate properties. It provides functionalities for adding, updating, and deleting properties, as well as viewing property details. This project is built using the Spring Boot framework, making it easy to develop and deploy robust web applications.

## Features

- **Property Management**: Add, update, and delete real estate properties.
- **Database Schema Management**: Utilizes Liquibase for managing database schema changes and versioning.
- **Web Interface**: Integrates Thymeleaf for server-side templating, providing a user-friendly web interface for interacting with the application.

## Tools Used

- **Spring Boot**: Framework for building Java-based enterprise applications.
- **Spring Boot Starter Data JPA**: Provides support for Spring Data JPA, simplifying data access layer implementation.
- **Spring Boot Starter Thymeleaf**: Integrates Thymeleaf, a modern server-side Java template engine.
- **Liquibase**: Database schema change management tool.
- **Project Lombok**: Library for reducing boilerplate code in Java.
- **PostgreSQL JDBC Driver**: Allows Java programs to connect to a PostgreSQL database.
- **Spring Boot Starter Test**: Support for writing unit and integration tests.
- **Spring Retry**: Module for handling transient failures gracefully.

## Database Design

![db-design.png](src%2Fmain%2Fresources%2Fimages%2Fdb-design.png)

## Getting Started

To get started with the Realstate project, follow these steps:

1. Clone the repository: `git clone <repository-url>`
2. Navigate to the project directory: `cd realstate`
3. Build the project: `./gradlew build`
4. Run the application: `./gradlew bootRun`
5. Access the application in your web browser at `http://localhost:8080`