FROM openjdk:8-jdk-alpine

ARG JAR_FILE=build/libs/*.jar

COPY ${JAR_FILE} registrar-propiedad-1.0.jar

ENTRYPOINT ["java","-jar","/registrar-propiedad-1.0.jar"]