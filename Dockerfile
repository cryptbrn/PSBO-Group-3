FROM ubuntu:20.04

RUN apt-get update
RUN apt install -y default-jre 
RUN apt install -y maven

WORKDIR /app

COPY . /app

EXPOSE 8080

ENTRYPOINT ["mvn", "spring-boot:run"]
