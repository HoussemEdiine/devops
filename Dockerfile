FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
RUN mvn clean package
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]