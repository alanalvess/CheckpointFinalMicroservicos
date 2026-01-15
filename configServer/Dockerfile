#FROM openjdk:19-jdk-alpine3.15
#WORKDIR /config-server
#EXPOSE 8888
#COPY target/config-service.jar /config-server/app.jar
#ENTRYPOINT ["java", "-jar", "app.jar"]

FROM openjdk:21-jdk-alpine

WORKDIR /config-server
COPY target/config-service.jar app.jar

EXPOSE 8888

HEALTHCHECK --interval=30s --timeout=10s --start-period=10s CMD wget -qO- http://localhost:8888/actuator/health || exit 1

ENTRYPOINT ["java", "-jar", "app.jar"]
