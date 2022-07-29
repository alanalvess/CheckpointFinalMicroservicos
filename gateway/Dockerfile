FROM openjdk:19-jdk-alpine3.15
WORKDIR /Gateway
EXPOSE 8080
COPY target/gateway-service.jar /Gateway/app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]