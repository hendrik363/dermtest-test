# Dermtest Backend developer - test assignment

## Application commands

### Compile
& "<mvnw.cmd path>" compile -f "<pom.xml path>"

### Package
& "<mvnw.cmd path>" package -f "<pom.xml path>"

### Run
java -jar ./target/dermtest.jar

### Link to API
localhost:8080/api/v1/doctors

### API Calls

1. GetDoctors
- GET request to URL localhost:8080/api/v1/doctors
2. SearchDoctors
- GET request to URL localhost:8080/api/v1/doctors/search/{searchTerm}
3. AddDoctor
- POST request to URL localhost:8080/api/v1/doctors with doctor json body. Example json body: {
    "doctorName": "",
    "birthDate": "",
    "specialization": "",
    "email": "",
    "phoneNumber": ""
} 
4. GetById
- GET request to URL localhost:8080/api/v1/doctors/{id}
5. DeleteDoctor
- POST request to URL localhost:8080/api/v1/doctors/delete/{id}
6. UpdateDoctor
- PUT request to URL localhost:8080/api/v1/doctors/update/{id} with json body of updated doctor. Example json body: {
    "doctorName": "",
    "birthDate": "",
    "specialization": "",
    "email": "",
    "phoneNumber": ""
}

I created a Spring boot 2.7.18 API application. This spring boot application backend consists of 3 levels. First Level is the controller level, second is the service level, and the third and final level is the JPA repository level.
I also added some forntend for the api. The fronend is html5 with thymeleaf and consists of a homepage, doctor adding form, table of doctors(with crud capabilities). The homepage consists of buttons for the possible usecases for the application:
1. Form for adding new doctors.
2. OpenApi documentation link
3. Table of doctors, with crud possibilities.
4. H2 database link
5. Project github link.

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

The result application has a working api with a frontend to help navigate the program. The project took 20h to complete.


 



