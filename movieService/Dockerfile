FROM openjdk:19-jdk-alpine3.15
WORKDIR /movie-service
EXPOSE 8082
COPY target/movie-service.jar /movie-service/app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]