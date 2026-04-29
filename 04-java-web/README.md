# Java Web

Projeto de testes web em Java usando Selenium, JUnit e WebDriverManager.

## Requisitos

- Java JDK 17 ou superior
- Apache Maven
- Google Chrome instalado

## Como executar

### Via Terminal
1. Abra um terminal na pasta `04-java-web`
2. Rode:
   ```bash
   mvn test
   ```

### Via VS Code (Debug/Run)
1. Abra a pasta `04-java-web` no VS Code
2. Use **F5** ou vá em **Run → Start Debugging**
3. Escolha uma das configurações:
   - **Run All Tests** - Executa todos os testes
   - **Run HomePageTest** - Executa apenas os testes JUnit
   - **Run CucumberRunner** - Executa os testes BDD
   - **Debug HomePageTest** - Debug modo nos testes JUnit
   - **Debug CucumberRunner** - Debug modo nos testes BDD

### Via VS Code Tasks
1. **Ctrl+Shift+P** → **Tasks: Run Task**
2. Escolha:
   - **Run All Tests**
   - **Run HomePageTest**
   - **Run CucumberRunner**
   - **Generate Allure Report**
   - **Clean and Test**

## O que está aqui

- `pom.xml` — dependências do projeto
- `src/test/java/com/estudo/TestWeb.java` — classe de teste web

## Observações

- O WebDriverManager baixa o ChromeDriver automaticamente.
- Se você tiver mais de uma instalação do Chrome, use a versão padrão do sistema.
- Verifique se o `JAVA_HOME` está configurado corretamente.
