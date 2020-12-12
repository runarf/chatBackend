FROM openjdk:14-alpine

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn

COPY pom.xml .

RUN dos2unix mvnw

RUN ./mvnw dependency:go-offline -B

COPY src src

RUN ./mvnw package -DskipTests

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "target/chat-0.0.1.jar"]