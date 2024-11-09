# Use the official OpenJDK image as a base
FROM eclipse-temurin:22

# Set the working directory
WORKDIR /app
# Copy the Spring Boot jar file into the container
COPY target/spring-docker-kubernetes-1.0-SNAPSHOT.jar app.jar
# Expose the application port
EXPOSE 8080
# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
