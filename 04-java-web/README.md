# Java Web

Projeto de testes web em Java usando Selenium, JUnit e WebDriverManager.

## Requisitos

- Java JDK 17 ou superior
- Apache Maven
- Google Chrome instalado

## Como executar

1. Abra um terminal na pasta `04-java-web`
2. Rode:
   ```bash
   mvn test
   ```

## O que está aqui

- `pom.xml` — dependências do projeto
- `src/test/java/com/estudo/TestWeb.java` — classe de teste web

## Observações

- O WebDriverManager baixa o ChromeDriver automaticamente.
- Se você tiver mais de uma instalação do Chrome, use a versão padrão do sistema.
- Verifique se o `JAVA_HOME` está configurado corretamente.
