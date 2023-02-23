
FROM openjdk:11
LABEL key="wilsonev.saldarriaga88@gmail.com" 
WORKDIR /app
ADD target/porcentaje-wilson-tenpo-0.0.1-SNAPSHOT.jar /app/porcentaje.jar
CMD ["java","-jar", "/app/porcentaje.jar"]