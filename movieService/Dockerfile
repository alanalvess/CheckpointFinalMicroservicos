#FROM openjdk:19-jdk-alpine3.15
#WORKDIR /movieDTO-service
#EXPOSE 8082
#COPY target/movieDTO-service.jar /movieDTO-service/app.jar
#ENTRYPOINT ["java", "-jar", "app.jar"]

FROM openjdk:21-jdk-alpine

WORKDIR /movieDTO-service
COPY target/movieDTO-service.jar app.jar

EXPOSE 8082

HEALTHCHECK --interval=30s --timeout=10s --start-period=10s CMD wget -qO- http://localhost:8082/actuator/health || exit 1

ENTRYPOINT ["java", "-jar", "app.jar"]
