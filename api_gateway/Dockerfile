FROM openjdk:11-jdk-slim-stretch
EXPOSE 8080
ADD target/api-gateway-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
