# Use an official JDK 21 base image
FROM eclipse-temurin:21-jdk as build

# Set workdir and copy project files
WORKDIR /app
COPY . .

# Package the application (assuming Maven wrapper present)
RUN mvn clean package -DskipTests

# Use a smaller runtime image for final artifact
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copy jar from builder stage
COPY --from=build /app/target/*.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
