FROM openjdk:11-jdk-slim-stretch
EXPOSE 8080
ADD target/discovery-server-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
