FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/BookService-0.0.1-SNAPSHOT.jar /app/bookservice.jar

EXPOSE 8080

CMD ["java", "-jar", "BookService.jar"]