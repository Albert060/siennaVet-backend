# Etapa 1: Build del JAR
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
# Agrega esta línea para dar permisos de ejecución al script mvnw
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline
COPY src ./src
RUN ./mvnw clean package -DskipTests -X

# Etapa 2: Imagen final para correr la app
FROM eclipse-temurin:21-jdk
WORKDIR /app

COPY --from=build /app/target/veterinariatfm-0.0.1-SNAPSHOT.jar veterinariatfm.jar

ENTRYPOINT ["java", "-jar", "veterinariatfm.jar"]