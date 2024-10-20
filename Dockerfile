# Stage 1: Build the JAR file
FROM maven:3.9.7-amazoncorretto-21 AS build
WORKDIR /app
COPY pom.xml .
COPY movie-api/src ./movie-api/src
COPY movie-api/pom.xml ./movie-api/pom.xml
COPY movie-business/src ./movie-business/src
COPY movie-business/pom.xml ./movie-business/pom.xml
COPY omdb-api-client/src ./omdb-api-client/src
COPY omdb-api-client/gen ./omdb-api-client/gen
COPY omdb-api-client/pom.xml ./omdb-api-client/pom.xml
COPY tmdb-api-client/src ./tmdb-api-client/src
COPY tmdb-api-client/pom.xml ./tmdb-api-client/pom.xml

RUN mvn help:evaluate -Dexpression=settings.localRepository -q -DforceStdout
RUN mvn clean package -q
# RUN rm -rf /root/.m2


# Stage 2: Run the application
FROM openjdk:21
VOLUME /tmp
EXPOSE 8080
COPY --from=build /app/movie-business/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]