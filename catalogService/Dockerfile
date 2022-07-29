FROM openjdk:19-jdk-alpine3.15
WORKDIR /catalog
EXPOSE 8072
COPY target/catalog-service.jar /catalog/app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]