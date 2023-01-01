# PointOfSale
Point of Sale API implementation by "Drop Database" based on the technical design by "Skestam_Kartu"
The project is a Java EE 8 API. Java version 16+, dependencies are managed by Maven, server is JBoss Wildfly 26, database is PostgreSQL, migrations managed by Flyway.
The project build to a WAR artifact that contains the API and swagger docs page.
# Architecture
The API uses Controller-Service-Repository architecture.
- The controllers use javax.ws.rs annotations to describe the endpoints.
- The services do all the logic and mapping between DTOs and persistence entities.
- The repositories are responsibe for getting data from the database using javax.persistence.
# How to run
- Install docker
- Install maven
- Install java 16+ (tried with Java 16 and Java 18, both worked, newer versions should work too)
1. Make sure that ports 5432 (for postgres database), 8080 (for the application), 9990 (for server management) are not used
2. Clone/Download the project
3. Run ```runDatabase.sh```
4. Run ```runServer.sh```
5. Go to ```http://localhost:8080/pos-1.0.0/docs``` to use the swagger UI, or use any other program that can send HTTP requests, the base path of the API is ```http://localhost:8080/pos-1.0.0/api```
