# Drones
Test task for Musala Soft

Hi, everyone.
I am glad to welcome you to my version of Drone Control Service.

http://localhost:8080/swagger-ui/index.html - Swagger UI for the API of the service

## Setting up for local development
There are 2 way launches of the project:

First way:
```bash
docker-compose up -d
```

In this variant will start all environment (DB + application)

Second way:
```bash
docker-compose -f docker-compose-dev.yml up -d
```
In this variant will start only DB environment.
After this you could start project in Intellij Idea using profile "dev"
or using command below:
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
``` 
## Accepted assumptions and limitations

1. Drones and medicine enters in system by registration. It is like a creating entities.
2. Order initialization available only for drones with state IDLE. this process changing state to LOADING.  
   After this you can change state only this way: LOADING -> LOADED -> DELIVERING -> DELIVERED -> RETURNING -> IDLE 
	* see: http://localhost:8080/swagger-ui/index.html#/Order%20controller/updateOrderState
3. Charging drones doing by @Scheduled and possible only for drones are located at the base (have state IDLE). 
This component add 5% to battery level every 10 minutes. Also this component immitate charge consumption (-10% every 10 minutes)

## Possible improvements if I had more time
1. Using Camunda for managing business process
2. Devision to microservices
3. Tests must have!!!