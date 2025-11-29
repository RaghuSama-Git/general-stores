# Stage 1: build with Maven
FROM maven:3.9.5-eclipse-temurin-17 AS builder
WORKDIR /workspace
# copy maven files first for caching
COPY pom.xml .
COPY src ./src
RUN mvn -B clean package -DskipTests

# Stage 2: runtime image
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=builder /workspace/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
