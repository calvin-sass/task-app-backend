# Stage 1: Build the application
FROM maven:3.9.6-eclipse-temurin-21 as builder

# Set working directory inside the container
WORKDIR /app

# Copy Maven files first for better caching
COPY pom.xml .
COPY src ./src

# Build the application without running tests
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:21-jdk-alpine

# Set working directory inside the container
WORKDIR /app

# Copy the built JAR file from the previous stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the port the app runs on (optional, helpful for local testing)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
