# 🤖 Automação Web do Zero - Guia de Início Rápido

## ⚡ Executar Testes em 3 Passos

### 1️⃣ Instalar Dependências
```bash
cd C:\Users\User\JAVA_WEB\automacao-do-zero\04-java-web
mvn clean install
```

### 2️⃣ Executar Testes
```bash
mvn test
```

### 3️⃣ Ver Relatório
```bash
mvn allure:report
mvn allure:serve
```

---

## 📁 Estrutura Importante

```
src/
├── main/java/com/estudo/pages/        ← Páginas (onde definem URLs)
└── test/
    ├── java/com/estudo/
    │   ├── support/DriverContext.java  ← Gerenciador de Driver
    │   ├── steps/testSteps.java        ← Passos dos testes
    │   └── runner/RunCucumberTest.java ← Executor
    └── resources/features/             ← Testes em Gherkin (.feature)
```

---

## 🎯 Onde Abrem as URLs?

### Em MetodoPage.java:
```java
public static final String URL = 
    "https://www.getguru.com/solutions/km-automation...";

public void abrir() {
    driver.get(URL);  // Aqui abre!
}
```

---

## 🚀 Criar seu Primeiro Teste

### 1. Feature (arquivo .feature)
**Arquivo:** `src/test/resources/features/CT002-Meu-Teste.feature`
```gherkin
Feature: Meu primeiro teste

  Scenario: Teste simples
    Given que acesso a página
    Then devo ver conteúdo
```

### 2. Page Object
**Arquivo:** `src/main/java/com/estudo/pages/MinhaPage.java`
```java
package com.estudo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MinhaPage {
    private WebDriver driver;
    private By elemento = By.id("id-elemento");

    public MinhaPage(WebDriver driver) {
        this.driver = driver;
    }

    public void abrir() {
        driver.get("https://sue-url.com");
    }

    public boolean validar() {
        return driver.findElement(elemento).isDisplayed();
    }
}
```

### 3. Steps em testSteps.java
```java
private MinhaPage minha;

@Given("que acesso a página")
public void acessar() {
    minha = new MinhaPage(DriverContext.getDriver());
    minha.abrir();
}

@Then("devo ver conteúdo")
public void validar() {
    assertTrue(minha.validar());
}
```

### 4. Rodar!
```bash
mvn test
```

---

## 📚 Links Rápidos

- [README Completo](README_começar_Aqui.md) - Guia detalhado
- [Exemplos Práticos](EXEMPLOS_PRATICOS_Terceiro_passo.md) - Código pronto para copiar
- [Selenium Docs](https://www.selenium.dev/)
- [Cucumber Docs](https://cucumber.io/)
- [XPath Tutorial](https://www.w3schools.com/xml/xpath_intro.asp)

---

## 💡 Dicas Rápidas

```java
// Localizadores
By.id("id")
By.xpath("//button[text()='Enviar']")
By.cssSelector(".class")

// Ações
driver.get("url")
driver.findElement(By.id("id")).sendKeys("texto")
driver.findElement(By.id("id")).click()

// Validações
assertTrue(driver.findElement(By.id("id")).isDisplayed())
assertEquals("esperado", driver.getTitle())
```

---

**Pronto! Bora aos testes! 🚀**

