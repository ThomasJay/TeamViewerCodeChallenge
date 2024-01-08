# TeamViewerCodeChallenge
Code Challenge for TeamViewer

This application consist of a Spring Boot Java application providing end points for an OpenAPI Yaml configuration.

The source for the API Definition is found in /src/main/resources/openapi3.yaml

The source files are built using Maven and deposited in the target folder so many files appear to be missing until the initial build.

You can generate the code using maven

mvn clean install

This will then provide all the files that are needed for the code.

You can then run this code and access the Swagger Doc at

http://localhost:8080/swagger-ui/index.html

This application runs on port 8080 which is defined in the application.properties file

You can build the application as a fat jar and then deploy it with Docker using the supplied docker file.

mvn clean compile package -DskipTests  

Then build teh docker file

docker build -t thomasjay/teamviewercodechallanege:0.0.1 .  

Deploy into docker

docker run -d -p 8080:8080 --name test_service thomasjay/teamviewercodechallanege:0.0.1


Check out more at https://youtube.com/@fastandsimpledevelopment

The base code is completed.

I did not write any tests

I did not create a docker compose file.

I was told this would take 1 hr to complete and I should not spend more than 3 hrs on this.

I spent several hours getting my Env up on a new Mac Book Pro so I had little time left to complete the code.

I used a Maven Plugin to generate the code from the OpenAPI file.



