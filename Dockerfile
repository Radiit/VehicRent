# Use OpenJDK 17 as base image
FROM eclipse-temurin:17-jdk-focal

# Set working directory
WORKDIR /app

# Copy maven files
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Make mvnw executable
RUN chmod +x mvnw

# Copy source code
COPY src src

# Build the application
RUN ./mvnw package -DskipTests

# Expose port 5590
EXPOSE 5590

# Run the application
CMD ["java", "-jar", "target/vehicrent-0.0.1-SNAPSHOT.jar"] 