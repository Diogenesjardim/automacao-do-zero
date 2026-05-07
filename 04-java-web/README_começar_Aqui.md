# 🤖 Automação Selenium Web com Java e Cucumber

Um projeto completo de **automação de testes web** usando **Selenium**, **Java**, **Cucumber (BDD)** e **Allure Reports**.

Criado para fins educacionais, mostrando as melhores práticas com **POM (Page Object Model)** e **BDD (Behavior Driven Development)**.

---

## 📋 Índice

1. [Estrutura do Projeto](#-estrutura-do-projeto)
2. [Pré-requisitos](#-pré-requisitos)
3. [Instalação](#-instalação-e-configuração)
4. [Como Executar](#-como-executar-os-testes)
5. [Entendendo a Arquitetura](#-entendendo-a-arquitetura)
6. [Adicionando Novos Testes](#-como-adicionar-novos-testes)
7. [Configuração de URLs](#-entendo-a-configuração-de-url)
8. [Relatórios](#-gerando-relatórios)

---

## 🗂️ Estrutura do Projeto

```
04-java-web/
├── pom.xml                           # Dependências Maven
├── README.md                         # Este arquivo
├── src/
│   ├── main/java/com/estudo/pages/   # 📄 Page Objects (POM)
│   │   └── MetodoPage.java           # Página com localizadores
│   └── test/
│       ├── java/com/estudo/
│       │   ├── base/BaseTest.java          # ⚙️ Configuração WebDriver
│       │   ├── runner/RunCucumberTest.java # 🚀 Executor
│       │   ├── steps/testSteps.java        # 🎬 Steps Cucumber
│       │   └── support/DriverContext.java  # 🔌 Gerenciador
│       └── resources/features/
│           └── CT001-Abrir a pagina.feature # ✍️ Testes Gherkin
└── target/                           # Compilação (gerado)
```

---

## 📦 Pré-requisitos

- ✅ **Java 17+** 
- ✅ **Maven 3.6+**
- ✅ **Git**
- ✅ **Google Chrome**

Verificar:
```bash
java -version
mvn -version
```

---

## ⚙️ Instalação e Configuração

```bash
cd C:\Users\User\JAVA_WEB\automacao-do-zero\04-java-web

# Instalar dependências
mvn clean install
```

---

## 🚀 Como Executar os Testes

```bash
# Todos os testes
mvn test

# Apenas Cucumber
mvn test -Dtest=RunCucumberTest

# Com Allure Report
mvn test
mvn allure:report
mvn allure:serve
```

---

## 🎯 Entendendo a Arquitetura

### 📍 DriverContext.java - Gerenciador de Driver

```java
public final class DriverContext {
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();
    
    public static WebDriver getDriver() {
        WebDriver driver = DRIVER.get();
        if (driver == null) 
            throw new IllegalStateException("WebDriver não inicializado");
        return driver;
    }
    
    public static void setDriver(WebDriver driver) {
        DRIVER.set(driver);
    }
}
```

**ThreadLocal:** Garante que cada thread tenha seu próprio WebDriver (tests paralelos).

---

### 📍 BaseTest.java - Configuração WebDriver

```java
public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();  // Baixa Chrome automaticamente
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");
        
        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
```

---

### 📍 MetodoPage.java - Page Object Model

```java
public class MetodoPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // URL - está aqui!
    public static final String URL = 
        "https://www.getguru.com/solutions/km-automation...";

    // Localizadores
    private final By body = By.tagName("body");
    private final By cookieButton = By.xpath("//button[normalize-space()='Okay']");
    private final By heroHeading = By.xpath("//h1[contains(...)]");

    public void abrir() {
        driver.get(URL);  // ⬅️ Abre a URL aqui
        wait.until(ExpectedConditions.visibilityOfElementLocated(body));
    }

    public void aceitarCookiesSeAparecer() {
        try {
            driver.findElement(cookieButton).click();
        } catch (NoSuchElementException e) {
            // Cookie não estava lá
        }
    }

    public boolean heroVisivel() {
        try {
            return wait.until(
                ExpectedConditions.visibilityOfElementLocated(heroHeading)
            ).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}
```

**Padrão POM:**
- ✅ Localizadores centralizados
- ✅ Métodos representam ações
- ✅ Fácil manutenção

---

### 📍 testSteps.java - Steps Cucumber

```java
public class testSteps {

    @Before
    public void beforeScenario() {
        WebDriver driver = new ChromeDriver();
        DriverContext.setDriver(driver);  // Armazena no ThreadLocal
    }

    @Given("que acesso a pagina de KM Automation do Guru")
    public void queLogo() {
        page = new MetodoPage(DriverContext.getDriver());
        page.abrir();  // Abre a URL
    }

    @When("aceito cookies se aparecer")
    public void aceitoCookies() {
        page.aceitarCookiesSeAparecer();
    }

    @Then("devo ver o conteudo principal da pagina")
    public void validarHero() {
        assertTrue(page.heroVisivel(), "Hero não está visível");
    }

    @After
    public void afterScenario() {
        DriverContext.getDriver().quit();
        DriverContext.clear();
    }
}
```

**Anotações Cucumber:**
- `@Given` = Pré-condição
- `@When` = Ação
- `@Then` = Resultado esperado

---

### 📍 CT001-Abrir a pagina.feature - Teste em Gherkin

```gherkin
Feature: Página de Knowledge Management Automation (Guru)

  Scenario: Abrir a página e validar conteúdo principal
    Given que acesso a pagina de KM Automation do Guru
    When aceito cookies se aparecer
    Then devo ver o conteudo principal da pagina
    And o titulo da pagina deve estar preenchido
```

---

## ➕ Como Adicionar Novos Testes

### 1️⃣ Criar Feature (.feature)

Arquivo: `src/test/resources/features/CT002-Seu-teste.feature`

```gherkin
Feature: Descrição do teste

  Scenario: Descrição do cenário
    Given precondição
    When ação
    Then resultado
```

### 2️⃣ Criar Page Object

Arquivo: `src/main/java/com/estudo/pages/SuaPage.java`

```java
package com.estudo.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class SuaPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public static final String URL = "https://seu-url.com";

    // Localizadores
    private final By elemento = By.id("id-do-elemento");

    public SuaPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void abrir() {
        driver.get(URL);
    }

    public void fazer Acao() {
        driver.findElement(elemento).click();
    }

    public boolean validar() {
        return driver.findElement(elemento).isDisplayed();
    }
}
```

### 3️⃣ Adicionar Steps

Em `testSteps.java`:

```java
private SuaPage suaPage;

@Given("que estou em um lugar")
public void setup() {
    suaPage = new SuaPage(DriverContext.getDriver());
    suaPage.abrir();
}

@When("faço algo")
public void acao() {
    suaPage.fazerAcao();
}

@Then("devo ver algo")
public void validacao() {
    assertTrue(suaPage.validar());
}
```

### 4️⃣ Executar!

```bash
mvn test
```

---

## 🌐 Onde está a Configuração de URL?

A URL é definida na **classe Page Object**:

```java
// Em MetodoPage.java
public static final String URL = 
    "https://www.getguru.com/solutions/km-automation...";

public void abrir() {
    driver.get(URL);  // ⬅️ Abre aqui
}
```

### ✏️ Para Mudar a URL:

**Opção 1 - Estática (simples):**
```java
public static final String URL = "https://nova-url.com";
```

**Opção 2 - Dinâmica (flexível):**
```java
public SuaPage(WebDriver driver, String url) {
    this.driver = driver;
    this.urlBase = url;
}

public void abrir() {
    driver.get(urlBase);
}

// No feature:
// Given que acesso "https://exemplo.com"
```

---

## 📊 Gerando Relatórios

### HTML (Cucumber nativo)
```bash
mvn test
# Arquivo: target/cucumber-report.html
```

### Allure (mais bonito!)
```bash
mvn test
mvn allure:report
mvn allure:serve  # Abre no navegador
```

---

## 🆘 Troubleshooting

### ❌ "WebDriver não foi inicializado"
- Verifique que `@Before` está em testSteps.java
- Confirme: `DriverContext.setDriver(driver)`

### ❌ "No scenarios found"
- Arquivos em: `src/test/resources/features/`
- Extensão: `.feature` (não `.txt`)
- RunCucumberTest.java tem: `@SelectClasspathResource("features")`

### ❌ "Element not found"
- Use F12 no Chrome para inspecionar
- Use XPath robustos: `By.xpath("//button[contains(text(), 'Enviar')]")`

### ❌ "ChromeDriver not found"
```bash
mvn clean install
```

---

## 🎯 Checklist para Novo Teste

- [ ] `.feature` em `src/test/resources/features/`
- [ ] Page Object em `src/main/java/com/estudo/pages/`
- [ ] Localizadores definidos
- [ ] Métodos de ação criados
- [ ] Steps adicionados em testSteps.java
- [ ] `mvn test` passou!
- [ ] Relatório gerado

---

## 📚 Exemplos Rápidos

### Abrir URL
```java
driver.get("https://exemplo.com");
```

### Clicar
```java
driver.findElement(By.id("btn")).click();
```

### Preencher
```java
driver.findElement(By.id("email")).sendKeys("teste@email.com");
```

### Validar Texto
```java
String texto = driver.findElement(By.tagName("body")).getText();
assertTrue(texto.contains("Bem-vindo"));
```

### Dropdown
```java
Select select = new Select(driver.findElement(By.id("pais")));
select.selectByVisibleText("Brasil");
```

### Checkbox
```java
WebElement check = driver.findElement(By.id("aceitar"));
if (!check.isSelected()) check.click();
```

---

## 🔗 Links Úteis

- Selenium: https://www.selenium.dev/
- Cucumber: https://cucumber.io/
- XPath: https://www.w3schools.com/xml/xpath_intro.asp
- ChromeDriver: https://chromedriver.chromium.org/
- WebDriverManager: https://github.com/bonigarcia/webdrivermanager
- Allure: https://docs.qameta.io/allure/

---

## 💡 Dicas Importantes

✅ **Use localizadores robustos:**
```java
// ✅ Bom
By.id("btn-submit")
By.xpath("//button[@class='primary']")

// ❌ Evite
By.xpath("//div[3]/button[1]")  // Frágil
```

✅ **Use waits explícitos:**
```java
// ✅ Bom
wait.until(ExpectedConditions.visibilityOfElementLocated(botao));

// ❌ Evite
Thread.sleep(5000);  // Lento e frágil
```

✅ **Nomes descritivos:**
```java
// ✅ Bom
@Given("que estou logado como usuário admin")

// ❌ Evite
@Given("que estou no sistema")
```

---

## 📞 Dúvidas?

1. Verifique a estrutura de pastas
2. Confira os imports
3. Leia a mensagem de erro
4. Use F12 para inspecionar elementos

---

**Bora automatizar! 🚀**
