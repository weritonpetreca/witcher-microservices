# Stage 1: Build the application using a dedicated Maven image for efficiency and reliability
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app

# Set the locale to UTF-8 to prevent character encoding issues during the build.
# This ensures the container environment handles special characters correctly.
ENV LANG C.UTF-8
ENV LANGUAGE C.UTF-8
ENV LC_ALL C.UTF-8

# Copy only the POM file first to leverage Docker's layer caching
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Build the application
RUN mvn package -DskipTests

# Runtime stage
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]