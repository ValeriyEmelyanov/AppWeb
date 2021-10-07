# JSP Servlet Hibernate Web Application: User Management
This is a simple User Management web application using JSP, 
Servlet, and Hibernate. 
This web application manages a collection of users 
with the basic feature: list, insert, update, delete

## Tools and Technologies Used
* Java 11
* Servlets
* Hibernate
* PostgreSQL 12
* Tomcat 9.5
* Reflections
* Command pattern
* JSP, JSTL

### Feature of the project
The action being performed is taken from the map of commands, 
the servlet path is taken as the key. 
The map is collected by the Reflections library 
from the "com.example.appweb.command.impl" package. 
To add a new command, it is enough to add 
a new implementation of the Command interface 
and replace it in the package.

### Useful links
* [JSP Servlet Hibernate Web Application](https://www.javaguides.net/2019/03/jsp-servlet-hibernate-web-application.html)
* [Dockerhub: Postgres](https://hub.docker.com/_/postgres)
* [Intro to Docker - Part 2 (Networking, Docker Compose)](https://www.youtube.com/watch?v=_m9JYAvFB8s&list=PLPZy-hmwOdEXZ7m_3JtanruRUhaAuI_uh&index=2)

## Run in Docker

### PostgreSQL in Docker
```
docker run --name pg12-usr -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=appusers -d -p 5434:5432 postgres:12.7
```
to see logs in the container
```
docker logs pg12-usr
```
to check database list in container: run bash
```
docker exec -it pg12-usr bash
```
run SQL Shell
```
psql -U postgres
```
list
```
\l
```
exit from SQL shell
```
\q
```
exit from bash
```
exit
```

### AppWeb in Docker
build war-file
```
mvn clean install
```
build the image
```
docker build -t app-web:1.0 .
```
create and run the container
```
docker run --name app-web -d -p 8080:8080 app-web:1.0 .
```
delete the container
```
docker rm -f app-web
```

### Network in Docker
create network
```
docker network create app-net
```
to see list of networks 
```
docker network ls
```
connect the container with database to the network
```
docker network connect app-net pg12-usr
```
create and run the container connected to the network
```
docker run --name app-web -d -p 8080:8080 --network=app-net app-web:1.0
```
and remove
```
docker network rm NETWORK
```

### Run with Docker Compose
prepare docker-compose.yml file and
```
docker-compose up
```

## Open in browser
```
http://localhost:8080/AppWeb/
```
