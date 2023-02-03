
FROM openjdk:11
MAINTAINER wilsonev.saldarriaga88@gmail.com
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} porcentaje-wilson-tenpo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/porcentaje-wilson-tenpo-0.0.1-SNAPSHOT.jar"]