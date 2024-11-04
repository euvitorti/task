# Usa a imagem do OpenJDK 21 como base
FROM openjdk:21-jdk

# Define o diretório de trabalho na imagem
WORKDIR /app

# Copia os arquivos do projeto da pasta Task para o diretório de trabalho
COPY Task .

# Executa o comando Maven para empacotar o projeto, ignorando os testes
RUN ./mvnw package -DskipTests

# Expõe a porta 8080
EXPOSE 8080

# Define o comando de entrada para executar o jar do projeto
ENTRYPOINT ["java", "-jar", "target/Task-0.0.1-SNAPSHOT.jar"]
