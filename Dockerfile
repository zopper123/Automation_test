# Use a lightweight OpenJDK image
FROM openjdk:17-jdk-slim

# Set working directory inside the container
WORKDIR /Playright_Automation

# Copy the jar file into the container
COPY target/test-project-3.4.4-SNAPSHOT.jar Playright_Automation.jar

# Expose port 8080
EXPOSE 2222

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "Playright_Automation.jar"]