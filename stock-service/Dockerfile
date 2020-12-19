FROM openjdk:12-jdk-alpine
VOLUME /tmp
ADD target/stock-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]