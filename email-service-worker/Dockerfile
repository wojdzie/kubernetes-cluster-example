FROM openjdk:19-slim

COPY build/libs/email-service-worker-1.0-SNAPSHOT.jar app.jar

EXPOSE 8090

ENTRYPOINT ["java", "-jar", "/app.jar"]