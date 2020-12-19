FROM openjdk:12-jdk-alpine
VOLUME /tmp
ADD target/eureka-service-0.0.1-SNAPSHOT.jar eureka.jar
ENTRYPOINT ["java","-jar","/eureka.jar"]