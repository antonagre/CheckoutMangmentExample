FROM adoptopenjdk/openjdk15:latest

COPY . /app
WORKDIR /app

EXPOSE 8085
CMD ["java","-jar","target/*.jar"]

