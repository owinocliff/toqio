FROM adoptopenjdk/openjdk11:latest
LABEL maintainer="owinoclifford@gmail.com"
WORKDIR /app/
COPY target/cardservice-0.0.1-SNAPSHOT.jar /app/cardservice-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "cardservice-0.0.1-SNAPSHOT.jar"]
