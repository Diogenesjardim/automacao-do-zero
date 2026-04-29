# Java Web — Testes com Selenium e Page Object

Projeto de testes web em Java usando Selenium, JUnit 5 e WebDriverManager.

---

## O que é o padrão Page Object?

Page Object é uma forma de organizar os testes web. A ideia é simples:

> **Cada página do site vira uma classe Java.**

Essa classe guarda:
- Os **elementos** da página (botões, campos, textos)
- As **ações** que o usuário pode fazer (clicar, digitar, verificar)

Os testes usam essa classe para interagir com a página, sem precisar saber como os elementos são encontrados.

### Por que usar?

| Sem Page Object | Com Page Object |
|---|---|
| Locators espalhados nos testes | Locators centralizados na classe da página |
| Se o site mudar, vários testes quebram | Se o site mudar, você altera só a classe da página |
| Testes difíceis de ler | Testes legíveis como uma história |

---

## Estrutura do projeto

```
04-java-web/
├── src/
│   ├── main/java/com/estudo/
│   │   └── pages/
│   │       └── HomePage.java        ← Page Object da página inicial
│   │
│   └── test/java/com/estudo/
│       ├── base/
│       │   └── BaseTest.java        ← Abre/fecha o navegador automaticamente
│       └── tests/
│           └── HomePageTest.java    ← Testes da página inicial
│
└── pom.xml                          ← Dependências do projeto
```

### Como cada arquivo se encaixa

```
BaseTest  (abre/fecha o navegador)
    ↑
HomePageTest  (os testes)  →  usa →  HomePage  (Page Object)
```

---

## Requisitos

- Java JDK 17 ou superior
- Apache Maven
- Google Chrome instalado

---

## Como executar

1. Abra um terminal na pasta `04-java-web`
2. Rode:
   ```bash
   mvn test
   ```
3. Para gerar o relatório Allure:
   ```bash
   mvn allure:serve
   ```

---

## Entendendo o código

### 1. Page Object (`HomePage.java`)

```java
public class HomePage {

    private final WebDriver driver;

    // URL da página
    private static final String URL = "https://exemplo.com/";

    // Locator — como encontrar o elemento na página
    private final By body = By.tagName("body");

    // Construtor recebe o driver
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Ação: abre a página
    public void abrir() {
        driver.get(URL);
    }

    // Verificação: a página carregou?
    public boolean estaCarregada() {
        return driver.findElement(body).isDisplayed();
    }
}
```

### 2. Classe Base (`BaseTest.java`)

Cuida de abrir e fechar o navegador. Todos os testes herdam dela.

```java
public class BaseTest {
    protected WebDriver driver;

    @BeforeEach  // roda antes de cada teste
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterEach   // roda depois de cada teste
    public void tearDown() {
        driver.quit();
    }
}
```

### 3. Teste (`HomePageTest.java`)

Usa o padrão **Arrange / Act / Assert**:

```java
@Test
public void deveAbrirSiteEValidarPagina() {
    // Arrange — prepara
    HomePage homePage = new HomePage(driver);

    // Act — executa
    homePage.abrir();

    // Assert — verifica
    assertTrue(homePage.estaCarregada());
}
```

---

## Observações

- O WebDriverManager baixa o ChromeDriver automaticamente — não precisa instalar nada.
- Se tiver mais de uma instalação do Chrome, use a versão padrão do sistema.
- Verifique se o `JAVA_HOME` está configurado corretamente.
