# work-distribution-service

Download and unzip the source repository for this guide, or 

clone it using Git: 
git clone https://github.com/libranswapy/work-distribution-service.git

Maven build 
mvn clean install
mvn compile
 
If you are using Maven, you can run the application using ./mvnw spring-boot:run. Or you can build the JAR file with ./mvnw clean package. Then you can run the JAR file:
java -jar target/gs-rest-service-0.1.0.jar

Install Postman in chrome as a plugin from the site below for testing the service. Then run Postman app
https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=en

Test the service
Import postman json for create and update service. This file is located within the folder 
FileName : TaskDistribution.postman_collection.json

REST service endpoints using the postman json attached.
Create Task for an Agent
http://localhost:8080/create

Update task completed 
http://localhost:8080/update
