FROM openjdk:17.0.2-jdk-slim-buster
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
ENV SPRING_PROFILE="dev"
EXPOSE 8080
ENTRYPOINT ["java","-Dspring.profiles.active=${SPRING_PROFILE}","-jar","/application.jar"]