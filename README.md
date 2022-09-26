# Spring Boot Microservices

## Description
This project contains the following modules:
- api-gateway
- configuration-server
- discovery-server
- inventory-service
- notification-service
- order-service
- product-service

## Prerequisites
- Maven 3
- Java 11

## Technologies
- API Gateway
- Config Server
- Eureka
- Vault
- Bootstrap
- Actuator
- KeyCloak
- Bus
- RabbitMQ

## Commands
### Generate the application jar file
- Run `mvn clean package` to generate a jar file.

### Build as a docker container
- `docker login`
- `docker build -t {DOCKER_ACCOUNT}/{APPLICATION_NAME}`, e.g `docker build -t juanyee/order-service`
- `docker push {DOCKER_ACCOUNT}/{APPLICATION_NAME}`. e.g `docker push juanyee/order-service`.