# Spring Boot Microservices

## Description
This project contains the following modules:
- discovery-server (port `8761`)
- api-gateway (port `8080`)
- order-service (port `8001`)
- configuration-server
- inventory-service
- notification-service
- product-service
- jenkins (port `8000`)

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

### Build application as a docker container
- `docker login`
- `docker build -t {DOCKER_ACCOUNT}/{APPLICATION_NAME} .`, e.g `docker build -t juanyee/order-service .`
- `docker push {DOCKER_ACCOUNT}/{APPLICATION_NAME}`. e.g `docker push juanyee/order-service`.
