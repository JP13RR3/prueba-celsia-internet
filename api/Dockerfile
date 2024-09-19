# Usa una imagen de Java para correr la app
FROM openjdk:17-jdk-alpine

# Establecer el directorio de trabajo en el contenedor
WORKDIR /pruebacelsia

# Copia el archivo JAR generado en el contenedor
COPY target/PruebaCelsiaApplication.jar /api/PruebaCelsiaApplication.jar

# Exponer el puerto 8080 (o el que uses en Spring Boot)
EXPOSE 8080
