FROM openjdk:19-slim

COPY build/libs/new-account-signup-service-1.0-SNAPSHOT.jar app.jar

EXPOSE 8091

ENTRYPOINT ["java", "-jar", "/app.jar"]