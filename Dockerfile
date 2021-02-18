FROM maven:3.6.0-jdk-13

COPY . /app
WORKDIR /app

EXPOSE 8085
CMD ["java","-jar","target/*.jar"]

