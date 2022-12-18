FROM gradle:7.1.1-jdk16-hotspot AS build
WORKDIR /app
COPY ./ .
RUN chmod +x ./gradlew
RUN gradle :server1:bootJar

FROM openjdk:15-jdk-alpine
EXPOSE 8080
RUN mkdir /app
COPY --from=build /app/server1/build/libs/*.jar app.jar

CMD ["java", "-jar", "app.jar"]
