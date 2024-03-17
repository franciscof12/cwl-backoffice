FROM gradle:jdk11 as builder

COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src

RUN gradle build --no-daemon

FROM openjdk:11-jre-slim

COPY --from=builder /home/gradle/src/build/libs/*.jar /app/app.jar

COPY wait-for-it.sh /app/wait-for-it.sh

WORKDIR /app

RUN chmod +x /app/wait-for-it.sh

CMD ["/app/wait-for-it.sh", "db:3306", "--", "java", "-jar", "app.jar"]
