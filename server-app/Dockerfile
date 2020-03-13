FROM openjdk:11-jdk-slim
WORKDIR /home/sandox-server
ARG REVISION
COPY target/server-0.0.1-SNAPSHOT.war /home/sandox-server/sandbox-server.war
ENTRYPOINT ["java","-jar","sandbox-server.war"]