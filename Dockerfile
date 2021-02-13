FROM maven:3.6.0-jdk-13

COPY . /app
WORKDIR /app
VOLUME /opt/myvolumes/m2:/root/.m2

RUN mvn clean install -DskipTests
RUN mvn -Dtest=Runner test