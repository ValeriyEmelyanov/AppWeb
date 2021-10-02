# JSP Servlet Hibernate Web Application: User Management
This is a simple User Management web application using JSP, 
Servlet, and Hibernate. 
This web application manages a collection of users 
with the basic feature: list, insert, update, delete

### Tools and Technologies Used
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
