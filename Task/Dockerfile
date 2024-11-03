# Use uma imagem base do Maven para construir o JAR
FROM maven:3.8.6-openjdk-21 AS build

# Defina o diretório de trabalho
WORKDIR /app

# Copie o arquivo pom.xml e o diretório src para o container
COPY pom.xml .
COPY src ./src

# Execute o comando para construir o JAR
RUN mvn clean package -DskipTests

# Agora, use uma imagem do OpenJDK para rodar o JAR
FROM openjdk:21-jdk

# Defina o diretório de trabalho
WORKDIR /app

# Copie o JAR construído da imagem anterior
COPY --from=build /app/target/Task-0.0.1-SNAPSHOT.jar app.jar

# Exponha a porta que a aplicação irá usar
EXPOSE 8080

# Comando para executar o JAR
ENTRYPOINT ["java", "-jar", "app.jar"]