FROM maven:3.6-adoptopenjdk-11 AS build

WORKDIR /build

COPY pom.xml .
COPY src src

RUN mvn package -DskipTests

FROM adoptopenjdk:11-jre-hotspot
WORKDIR /app

COPY keyist.p12 .

COPY --from=build /build/target/*.jar resource_server.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=seed", "resource_server.jar"]