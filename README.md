# Hotel Reservations System

### Author: Dominik Mikołajczyk

## Project Overview

The Hotel Reservations System is a comprehensive application designed to manage hotel room reservations. It allows users to create, read, update, and delete information related to clients, hotels, rooms, and reservations. The project leverages the Spring framework for backend development and connects to a PostgreSQL database to persist data.

## Project Objectives

The primary goal of this project was to design and implement a data model that accurately represents the relationships and entities involved in hotel reservations. Key objectives included:

- Designing a data model with at least 5 tables, including two OneToOne relationships and two OneToMany (or ManyToMany) relationships.
- Implementing at least 5 queries, with one supporting pagination.
- Providing RESTful endpoints for CRUD operations on the database entities.
- Utilizing a non-in-memory database for data persistence.

## Features

- **Data Model**: The application includes tables such as Clients, Hotels, Reservations, and Rooms. These tables are interconnected through various relationships, including OneToOne, OneToMany, and ManyToOne.
- **Database**: The application connects to a PostgreSQL database. Users must configure the database connection details (URL, username, and password) in the `application.properties` file.
- **REST API**: Each entity in the database has corresponding REST endpoints for GET, POST, PUT, and DELETE operations. These endpoints can be tested using tools like Postman.
- **Queries**: The application includes 7 queries per table, with one query supporting pagination to efficiently handle large datasets.

## Technical Requirements

- **Java Development Kit (JDK)**: Version 17 or higher is required to run this application.
- **Spring Framework**: Utilized for building the application.
- **Maven**: Used for project and package management.

## Setup Instructions

### 1. Configure Database

Update the `src/main/resources/application.properties` file with your PostgreSQL database connection details.

### 2. Build the Project

```bash
mvn clean install
```

### 3. Run the Application

```bash
mvn spring-boot:run
```

### 4. Test the Endpoints

Use Postman or any other API testing tool to interact with the REST endpoints.

