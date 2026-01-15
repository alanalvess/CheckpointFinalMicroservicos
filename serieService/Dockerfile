#FROM openjdk:19-jdk-alpine3.15
#WORKDIR /serieDTO-service
#EXPOSE 8092
#COPY target/serieDTO-service.jar /serieDTO-service/app.jar
#ENTRYPOINT ["java", "-jar", "app.jar"]

FROM openjdk:21-jdk-alpine

WORKDIR /serieDTO-service
COPY target/serieDTO-service.jar app.jar

EXPOSE 8092

HEALTHCHECK --interval=30s --timeout=10s --start-period=10s CMD wget -qO- http://localhost:8092/actuator/health || exit 1

ENTRYPOINT ["java", "-jar", "app.jar"]
