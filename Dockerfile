# Usar una imagen base con JDK 8 y Gradle
FROM gradle:8.3-jdk17 AS build

# Establecer un directorio de trabajo
WORKDIR /app

# Copiar archivos de tu proyecto al directorio de trabajo
COPY src /app

# Ejecutar Gradle para construir el proyecto
RUN gradle clean build

# Crear una nueva imagen basada en OpenJDK 8
FROM openjdk:17.0.2-jdk-slim

# Exponer el puerto que utilizará la aplicación
EXPOSE 8080

# Copiar el archivo JAR construido desde la etapa anterior
COPY --from=build /app/build/libs/api-eventos-0.0.1-SNAPSHOT.jar /app/api-eventos-0.0.1-SNAPSHOT.jar

# Establecer el punto de entrada para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/api-eventos-0.0.1-SNAPSHOT.jar"]