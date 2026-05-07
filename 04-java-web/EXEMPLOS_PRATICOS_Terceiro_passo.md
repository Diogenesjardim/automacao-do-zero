# 📚 Exemplos Práticos Prontos para Copiar

## ✏️ Exemplo 1: Teste Básico de Abertura de URL

### Feature (CT002-Abrir URL Simples.feature):
```gherkin
Feature: Abrir página externa

  Scenario: Validar abertura de página
    Given que abro a URL "https://www.google.com"
    Then devo ver o título "Google"
```

### Page Object (GooglePage.java):
```java
package com.estudo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class GooglePage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final String url;

    public GooglePage(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void abrir() {
        driver.get(url);
    }

    public String obterTitulo() {
        return driver.getTitle();
    }
}
```

### Steps (adicionar em testSteps.java):
```java
private GooglePage googlePage;

@Given("que abro a URL {string}")
public void abrirUrl(String url) {
    googlePage = new GooglePage(DriverContext.getDriver(), url);
    googlePage.abrir();
}

@Then("devo ver o título {string}")
public void validarTitulo(String titulo) {
    assertEquals(titulo, googlePage.obterTitulo());
}
```

---

## ✏️ Exemplo 2: Teste de Formulário

### Feature (CT003-Login.feature):
```gherkin
Feature: Teste de Login

  Scenario: Fazer login
    Given que estou na página de login
    When preencho email com "teste@email.com"
    And preencho senha com "123456"
    And clico no botão "Entrar"
    Then devo ver "Login realizado com sucesso"
```

### Page Object (LoginPage.java):
```java
package com.estudo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By campoEmail = By.id("email");
    private By campoSenha = By.id("senha");
    private By botaoEntrar = By.xpath("//button[contains(text(),'Entrar')]");
    private By msgSucesso = By.className("sucesso");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void abrir() {
        driver.get("https://seu-site.com/login");
    }

    public void preencherEmail(String email) {
        driver.findElement(campoEmail).sendKeys(email);
    }

    public void preencherSenha(String senha) {
        driver.findElement(campoSenha).sendKeys(senha);
    }

    public void clicarBotao(String nome) {
        By botao = By.xpath("//button[normalize-space()='" + nome + "']");
        driver.findElement(botao).click();
    }

    public String obterMensagem() {
        return driver.findElement(msgSucesso).getText();
    }
}
```

### Steps:
```java
private LoginPage loginPage;

@Given("que estou na página de login")
public void irParaLogin() {
    loginPage = new LoginPage(DriverContext.getDriver());
    loginPage.abrir();
}

@When("preencho email com {string}")
public void preencherEmail(String email) {
    loginPage.preencherEmail(email);
}

@When("preencho senha com {string}")
public void preencherSenha(String senha) {
    loginPage.preencherSenha(senha);
}

@When("clico no botão {string}")
public void clicarBotao(String nome) {
    loginPage.clicarBotao(nome);
}

@Then("devo ver {string}")
public void validarMensagem(String mensagem) {
    assertTrue(loginPage.obterMensagem().contains(mensagem));
}
```

---

## ✏️ Exemplo 3: Teste de Clique e Validação

### Feature (CT004-Clique.feature):
```gherkin
Feature: Teste de cliques

  Scenario: Clicar e validar resultado
    Given que estou na página de testes
    When clico no botão de teste
    Then devo ver a mensagem de sucesso.
```

---

## 🔗 Localizadores Comuns

```java
// ID
By.id("id-do-elemento")

// Name
By.name("nome-do-campo")

// XPath por Texto
By.xpath("//button[contains(text(), 'Enviar')]")

// XPath por Atributo
By.xpath("//input[@class='email']")

// CSS Selector
By.cssSelector(".btn-primary")

// Class
By.className("botao")

// Tag
By.tagName("button")
```

---

## ⚡ Atalhos Úteis

```java
// Clicar
driver.findElement(By.id("btn")).click();

// Preencher
driver.findElement(By.id("email")).sendKeys("teste@email.com");

// Obter texto
String texto = driver.findElement(By.id("msg")).getText();

// Obter atributo
String valor = driver.findElement(By.id("campo")).getAttribute("value");

// Verificar se está visível
boolean visivel = driver.findElement(By.id("elem")).isDisplayed();

// Verificar se está habilitado
boolean habilitado = driver.findElement(By.id("btn")).isEnabled();

// Limpar campo
driver.findElement(By.id("campo")).clear();

// Dropdown
Select select = new Select(driver.findElement(By.id("pais")));
select.selectByVisibleText("Brasil");

// Checkbox
driver.findElement(By.id("check")).click();
```

---

## 🚀 Executar

```bash
mvn test
```

**Veja README.md para guia completo!** 📖

