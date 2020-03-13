FROM openjdk:11-jdk-slim
WORKDIR /home/sandox-mock-server
ARG REVISION
COPY target/mock-server-0.0.1-SNAPSHOT.war sandbox-mock-server.war
ENTRYPOINT ["java","-jar","sandbox-mock-server.war"]