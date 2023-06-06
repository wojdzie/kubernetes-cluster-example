FROM openjdk:19-slim

COPY build/libs/password-reset-service-1.0-SNAPSHOT.jar app.jar

EXPOSE 8092

ENTRYPOINT ["java", "-jar", "/app.jar"]