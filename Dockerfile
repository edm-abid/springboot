FROM openjdk:17
EXPOSE 8083
ADD target/client.jar client.jar
ENTRYPOINT ["java","-jar","client.jar"]
