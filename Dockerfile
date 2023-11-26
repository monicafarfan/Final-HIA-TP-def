FROM maven:3.9.5 AS build
WORKDIR /app
COPY pom.xml /app
RUN mvn dependency:resolve
COPY . /app
RUN mvn clean
RUN mvn package -DskipTests

FROM openjdk:22
COPY --from=build /app/target/tpfinalhia2023-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD [ "java", "-jar", "app.jar" ]
