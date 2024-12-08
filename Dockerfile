# Etapa 1: Build do projeto
FROM maven:3.8.8-eclipse-temurin-17 as build

# Define o diretório de trabalho
WORKDIR /app

# Copia os arquivos do projeto para o container
COPY . .

# Compila e empacota a aplicação
RUN mvn clean package -DskipTests

# Etapa 2: Construção da imagem final
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho no container final
WORKDIR /app

# Copia o JAR gerado na etapa anterior para a imagem final
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta padrão do Spring Boot
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]