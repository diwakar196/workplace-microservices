
# WorkHub Microconnect

Independent services communicating asynchronously to store an object containing multiple entities in a relationship.

### Tech
1. Java 8
2. Spring Boot v2.7.14
3. Apache Kafka
4. Zipkin
5. Docker
6. MySQL

### Setup

1. Clone the repository using ***git clone***.
2. Setup the MySQL server and the DB and update the same in the application.properties / yaml file.
3. Build a kafka image on docker.
4. Run Zipkin jar file.
5. Run Microservices in the respective order ***Eureka Server, API-Gateway, Employee, Project, Team***
6. Use the API's to **create, update, delete** objects.

### Made By

**Diwakar Singh**

### Future Scope

CI/CD, Deployment, Better Error Handling, Kibana (logs) integration, Grafana (Monitoring)


