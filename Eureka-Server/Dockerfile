# Use OpenJDK 21 base image
FROM eclipse-temurin:21-jdk-alpine

# Set working directory inside container
WORKDIR /app

# Copy jar file (ensure your Eureka service is already built)
COPY build/libs/eureka-server-0.0.1-SNAPSHOT.jar app.jar

# Expose Eureka server port
EXPOSE 8761

# Command to run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
