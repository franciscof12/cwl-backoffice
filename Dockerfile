FROM gradle:jdk11 as builder

COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src

RUN gradle build --no-daemon

FROM openjdk:11-jre-slim

COPY --from=builder /home/gradle/src/build/libs/*.jar /app/app.jar

WORKDIR /app

CMD ["java", "-jar", "app.jar"]
