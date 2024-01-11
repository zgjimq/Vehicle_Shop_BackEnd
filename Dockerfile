FROM maven:3.8.3-openjdk-17 AS build

WORKDIR /app

COPY . .

RUN mvn package -DskipTests

FROM openjdk:17-jdk

COPY --from=build /app/targer/Vehicle-back-end-ZgjiQer.0.0.1-SNAPSHOT.jar Vehicle-back-end-ZgjiQer.jar

EXPOSE 8080

ENTRYPOINT [ "java", "jar", "Vehicle-back-end-ZgjiQer.jar" ]