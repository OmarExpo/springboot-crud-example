FROM openjdk:11
ADD target/springrest.jar springrest.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "springrest.jar"]