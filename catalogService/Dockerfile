#FROM openjdk:19-jdk-alpine3.15
#WORKDIR /catalog
#EXPOSE 8072
#COPY target/catalog-service.jar /catalog/app.jar
#ENTRYPOINT ["java", "-jar", "app.jar"]

FROM openjdk:21-jdk-alpine

WORKDIR /catalog
COPY target/catalog-service.jar app.jar

EXPOSE 8072

HEALTHCHECK --interval=30s --timeout=10s --start-period=15s CMD wget -qO- http://localhost:8072/actuator/health || exit 1

ENTRYPOINT ["java", "-jar", "app.jar"]
