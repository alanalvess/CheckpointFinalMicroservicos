#FROM openjdk:19-jdk-alpine3.15
#WORKDIR /eureka-server
#EXPOSE 8761
#COPY target/eureka-service.jar /eureka-server/app.jar
#ENTRYPOINT ["java", "-jar", "app.jar"]

FROM openjdk:21-jdk-alpine

WORKDIR /eureka-server
COPY target/eureka-service.jar app.jar

EXPOSE 8761

HEALTHCHECK --interval=30s --timeout=10s --start-period=10s CMD wget -qO- http://localhost:8761/actuator/health || exit 1

ENTRYPOINT ["java", "-jar", "app.jar"]
