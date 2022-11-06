FROM openjdk:17-alpine
MAINTAINER lxczzdd
COPY target/pastebox-0.0.1-SNAPSHOT.jar pastebin-backend.jar
ENTRYPOINT ["java","-jar","/pastebin-backend.jar"]