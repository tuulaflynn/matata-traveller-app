# Matata Traveller

This project involves designing and developing a full stack application. A travel guide application has been selected for this purpose.

- The application encompasses a MySQL database that adheres to the principles of normalization up to the third normal form (3NF). It is complemented by schema and data .SQL files, as well as an Entity-Relationship Diagram (ERD) for data organization.
- The backend was developed in Java, using the Spring Boot framework and Spring Data JPA for seamless interaction with the database. Object-Relational Mapping (ORM) was employed to facilitate this interaction
- Uses Spring DI and appropriate @Annotations in the code.
- Layered architecture: Model - DAO - Service - Controller. Additionally, it implements an Exception package (with GlobalExceptionHandler class).
- The backend incorporates exceptional custom error handling and thorough data validation.
- On the frontend, the application was constructed with the use of HTML, CSS, Bootstrap, and JavaScript.
- The deployment was facilitated by VS Code Live Server, enhancing the user experience.
- The application leverages third-party APIs for added functionality, including services for weather forecasting, currency exchange, and language translation.


## How to Install and Run the Project
The project is currently not cloud-hosted so to run the project you must: 
- clone the repository
- run the database server
- add an application.properties file in src/resources folder
    * application.properites is the configuration file for Spring Boot, it should include settings for database connection, server port and Hibernate (configure the Hibernate dialect for your database)
+ run the application in an IDE (to run backend server)
+ in VSCode open index.html with Live Server
