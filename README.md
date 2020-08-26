# healthcare-enrollee-management-service


## # API/Service functionality🐱‍🏍

   Using Spring Boot or Go, and your database of choice (PostgreSQL, MySQL, MongoDB -- any you'd like), develop a microservice for tracking the status of enrollees in a health care program.
   - Enrollees must have an id, name, and activation status (true or false), and a birth date
   - Enrollees may have a phone number (although they do not have to supply this)
   - Enrollees may have zero or more dependents
   - Each of an enrollee's dependents must have an id, name, and birth date
   
   The application we will be building will need to be able to do these things:
   - Add a new enrollee
   - Modify an existing enrollee
   - Remove an enrollee entirely
   - Add dependents to an enrollee
   - Remove dependents from an enrollee
   - Modify existing dependents
   
 ## Getting started
   - Start a postgres server with database name: Centene
   - Run the HealthcareEnrolleeManagementServiceApplication to start the service
   - Go to localhost:8080/swagger-ui.html to find information about the exposed endpoints and defined models

 ## API information
 
   - /enrollee -> Get, Post, Put and Delete mappings enrollees
   - /dependent -> Get, Post, Put and Delete mappings for dependents