# Dermtest Backend developer - test assignment

## Application commands

### Compile
& "<mvnw.cmd path>" compile -f "<pom.xml path>"

### Package
& "<mvnw.cmd path>" package -f "<pom.xml path>"

### Run
java -jar ./target/dermtest.jar

I created a Spring boot 2.7.18 API application. This spring boot application backend consists of 3 levels. First Level is the controller level, second is the service level, and the third and final level is the JPA repository level. 
The Api URL path is: localhost:8080/api/v1/doctors. 
I also added some forntend for the api. The fronend is html5 with thymeleaf and consists of a homepage, doctor adding form, table of doctors(with crud capabilities). The homepage consists of buttons, that link to the possible usecases for the api.

## Completed Tasks:

### Configuration:

1. Add file-based database: I added a file-based database using h2database and connected to it using JPA repository.
2. Add Lombok: I added Lombok to my spring boot api. Lombok was used to add constructoss, getters and setters to the Doctor model.
3. Add OpenApi documentation: OpenApi documentation is set up with springdoc-openapi-ui, and can be found on url localhost:8080/swagger-ui/index.html
4. Add log4j: I added log4j loggin for the service level of my backend. Every api call logs changes and errors.

### Development

1. Create data model (i.e doctor or nurse): I created a data model for doctors.
2. Create one of CRUD based controller with input/output JSON (i.e use your created data model): I created a RestController with CRUD possibilities, that controls all calls to the API.
3. Create one JPA repository for connecting to database: I created a JPA repository that connects to my h2 file-based database.
 



