# Programming Laboratory Class - Project: Hotel Reservations
### author: Dominik Mikołajczyk

## The task the of project
The aim of the project was to create a program that will write and read a specific data model. The author had to consider what type of data he wants to store in the final application and model this data by defining fields, tables and relationships between them. Additionaly:
- Data must contain at least 5 tables, two OneToOne relationships and two OneToMany (or ManyToMany) relationships
- There should be at least 5 queries created for the data. One of the queries must be paged
- The program should have REST endpoints for creating, reading, editing, deleting objects from the database
- The application should use a non-in-memory database

## Requirements:        
JDK 17 must be installed in order to run this application.
        
## Functionalities
Spring framework is used to develop the application and Maven tool is used for project and package management. Database consists of tables like Clients, Hotels, Reservations or Rooms and they hold detailed information about hotel room reservations by individual customers. Additionaly:
- The program connects with database created in PostgreSQL. To connect with it successfully, user has to enter in application.properties url, username and password for database.
- There are totally 6 tables, 2 OneToOne relationships, 3 OneToMany relationships and 3 ManyToOne relationships
- Each of 4 tables has 7 queries which one of them is paged and each of these tables has GET, POST, PUT and DELETE REST API endpoints (you can use application like Postman to send HTTP requests and test these endpoints).
