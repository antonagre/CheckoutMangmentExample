 FROM maven:3.6.0-jdk-13

 COPY . /app

 WORKDIR /app

 ##RUN mvn clean install -DskipTests
