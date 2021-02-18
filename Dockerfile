FROM

COPY . /app
WORKDIR /app

EXPOSE 8085
CMD ["java","-jar","target/*.jar"]

