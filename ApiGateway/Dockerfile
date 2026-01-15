#FROM openjdk:19-jdk-alpine3.15
#WORKDIR /Gateway
#EXPOSE 8080
#COPY target/gateway-service.jar /Gateway/app.jar
#ENTRYPOINT ["java", "-jar", "app.jar"]

FROM openjdk:21-jdk-alpine

WORKDIR /gateway
COPY target/gateway-service.jar app.jar

EXPOSE 8080

HEALTHCHECK --interval=30s --timeout=10s --start-period=10s CMD wget -qO- http://localhost:8080/actuator/health || exit 1

ENTRYPOINT ["java", "-jar", "app.jar"]
