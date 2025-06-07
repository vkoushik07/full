# Use official OpenJDK image as base
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy pom.xml and download dependencies (layer caching)
COPY pom.xml .
RUN apt-get update && apt-get install -y maven && mvn dependency:go-offline -B

# Copy all source code
COPY src ./src

# Build the Spring Boot app (produces jar)
RUN mvn clean package -DskipTests

# Expose your app port (change if different)
EXPOSE 6968

# Run the jar file
CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]
