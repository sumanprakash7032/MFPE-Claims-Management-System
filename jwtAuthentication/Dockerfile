FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8089
ADD target/*.jar auth-app.jar
ENTRYPOINT ["java ", "-jar", "/auth-app.jar"]