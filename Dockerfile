FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .

RUN apt-get install maven -y
RUN mvn clean install 

FROM openjdk:17-jdk-slim
COPY --from=build /target/algamoney-api-0.0.1-SNAPSHOT.jar demo.jar
ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo.jar"]