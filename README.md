# Web-API Developer Challenge - Contact API

## Launch

To launch the API Rest, first of all, launch the docker container which contain a MySql database, and after start the SprintBoot application.  
The database will initialise automatically with Sprint boot. 

### Docker
Launch database with Docker : 
```
cd docker
docker-compose run --build
```

#### Access
User : root  
Pass : toor  
Database : contact_api

### Application 
**Main class** : ch.proteck.contactapi.ContactApiApplication

### Swagger
[Swagger interface](http://localhost:8080/swagger-ui.html)