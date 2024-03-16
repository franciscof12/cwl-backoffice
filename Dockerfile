# Usar una imagen base oficial de Gradle
FROM gradle:jdk11 as builder

# Copiar los archivos del proyecto al contenedor
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src

# Construir la aplicación
RUN gradle build --no-daemon

# Usar una imagen base de OpenJDK para el contenedor final
FROM openjdk:11-jre-slim

# Copiar el ejecutable desde el contenedor de construcción al contenedor final
COPY --from=builder /home/gradle/src/build/libs/*.jar /app/app.jar

WORKDIR /app

# Ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]
