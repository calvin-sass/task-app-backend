# Use Eclipse Temurin as base image (OpenJDK)
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the jar file into the container
COPY target/*.jar app.jar

# Expose port (optional, for local docker testing)
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
