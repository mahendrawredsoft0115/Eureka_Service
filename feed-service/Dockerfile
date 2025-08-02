# Use official OpenJDK base image
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy the jar file (ensure your build creates this path)
COPY build/libs/feed-feed-0.0.1-SNAPSHOT.jar app.jar


# Expose the port
EXPOSE 8083

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
