# === Stage 1: Build the application ===
FROM maven:3.9.4-eclipse-temurin-17 AS build

WORKDIR /app

# Copy Maven wrapper and config files
COPY mvnw ./
COPY .mvn .mvn

# Copy pom.xml and download dependencies
COPY pom.xml ./
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline

# Copy the rest of the source code
COPY src ./src

# Package the app
RUN ./mvnw clean package -DskipTests

# === Stage 2: Run the application ===
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Start the app
ENTRYPOINT ["java", "-jar", "app.jar"]
