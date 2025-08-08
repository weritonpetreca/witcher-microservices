# --- Build Stage ---
# Use a full JDK image to build the application
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package -DskipTests

# --- Final Stage ---
# Use a slim JRE image for a smaller final image size
FROM openjdk:17-jdk-slim
WORKDIR /app
# Install curl for the healthcheck and clean up the apt cache
RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8766
ENTRYPOINT ["java", "-jar", "app.jar"]