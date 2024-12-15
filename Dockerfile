# Etapa 1: Build da aplicação usando Maven com Java 11
FROM maven:3.8.8-eclipse-temurin-11 AS builder

# Define o diretório de trabalho
WORKDIR /app

# Copia os arquivos do projeto para o container
COPY . .

# Compila o projeto e gera o JAR (sem testes para acelerar o build)
RUN ./mvnw clean package -DskipTests

# Etapa 2: Imagem final com OpenJDK 11 para executar a aplicação
FROM openjdk:11-jre-slim

# Define o diretório de trabalho no container final
WORKDIR /app

# Copia o arquivo JAR gerado na etapa anterior
COPY --from=builder /app/target/*.jar app.jar

# Expõe a porta padrão do Spring Boot
EXPOSE 8080

# Define o comando de inicialização da aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]