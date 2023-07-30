FROM openjdk:11.0.16
WORKDIR /app
COPY ./target/api-clientes-0.0.1-SNAPSHOT.jar .
EXPOSE 8081
ENTRYPOINT ["java","-jar","api-clientes-0.0.1-SNAPSHOT.jar"]
