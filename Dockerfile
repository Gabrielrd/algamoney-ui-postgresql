# Escolha a imagem base com Java 17 (ou a versão que sua aplicação requer)
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo JAR gerado pelo build para dentro do container
COPY target/algamoneyapi-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta que a aplicação Spring Boot utiliza (por padrão, 8080)
EXPOSE 8080

# Comando para executar o JAR
ENTRYPOINT ["java", "-jar", "app.jar"]