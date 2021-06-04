FROM openjdk:11
ADD target/simple-spring-boot-app.jar simple-spring-boot-app.jar
EXPOSE 8070
ENTRYPOINT ["java", "-jar", "simple-spring-boot-app.jar"]