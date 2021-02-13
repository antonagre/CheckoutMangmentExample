FROM maven:3.6.0-jdk-13

COPY target/*.jar /app
WORKDIR /app


