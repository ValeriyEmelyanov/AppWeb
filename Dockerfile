FROM tomcat:9-jdk11
ADD target/AppWeb-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/AppWeb.war
EXPOSE 8080
CMD ["catalina.sh", "run"]