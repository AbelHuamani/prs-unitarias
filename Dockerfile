# Usar una imagen base de JDK 17
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR de la aplicación al contenedor
COPY target/com.seguridad.sisfarma-1.0.jar com.seguridad.sisfarma-1.0.jar

# Exponer el puerto en el que la aplicación se ejecutará
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "com.seguridad.sisfarma-1.0.jar"]