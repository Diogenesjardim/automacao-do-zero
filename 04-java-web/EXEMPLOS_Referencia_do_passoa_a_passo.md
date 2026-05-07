# 📝 Snippets de Código - Cópia e Cola

## 🔗 Localizadores

```java
// Por ID (melhor e mais rápido)
By.id("nome-id")

// Por Name
By.name("nome-campo")

// Por XPath - Texto
By.xpath("//button[contains(text(), 'Enviar')]")
By.xpath("//button[text()='Entrar']")
By.xpath("//span[normalize-space()='OK']")

// Por XPath - Atributo
By.xpath("//input[@class='email']")
By.xpath("//input[@type='email'][@name='email']")
By.xpath("//*[@id='botao-principal']")

// Por XPath - Combinado
By.xpath("//form[@id='login']//button[@type='submit']")

// Por CSS
By.cssSelector(".btn-primary")
By.cssSelector("input[type='email']")
By.cssSelector(".form .input-field")
By.cssSelector("button.primary[data-action='submit']")

// Por Class
By.className("botao-principal")

// Por Tag
By.tagName("button")

// Por Link Text
By.linkText("Clique aqui")

// Por Partial Link
By.partialLinkText("aqui")
```

---

## ⚡ Ações Comuns

```java
// Abrir URL
driver.get("https://exemplo.com");

// Clicar
driver.findElement(By.id("btn")).click();

// Preencher campo
driver.findElement(By.id("email")).sendKeys("teste@email.com");

// Limpar campo
driver.findElement(By.id("campo")).clear();

// Obter texto
String texto = driver.findElement(By.id("msg")).getText();

// Obter atributo (valor de input)
String valor = driver.findElement(By.id("campo")).getAttribute("value");

// Obter atributo data
String data = driver.findElement(By.id("elem")).getAttribute("data-id");

// Voltar página
driver.navigate().back();

// Recarregar
driver.navigate().refresh();

// Título da página
String titulo = driver.getTitle();

// URL atual
String url = driver.getCurrentUrl();

// Fechar driver
driver.quit();
```

---

## ✅ Validações (Assertions)

```java
// Igual
assertEquals("esperado", atual);
assertEquals(5, numero);

// Verdadeiro/Falso
assertTrue(driver.findElement(By.id("elem")).isDisplayed());
assertFalse(driver.findElement(By.id("elem")).isEnabled());

// Nulo
assertNull(valor);
assertNotNull(valor);

// Contém
assertTrue(texto.contains("palavra"));

// Teste completo
assertTrue(
    driver.findElement(By.id("msg")).isDisplayed(),
    "Mensagem não foi exibida"
);
```

---

## 🔌 Verificações de Elemento

```java
// Visível?
boolean visivel = driver.findElement(By.id("elem")).isDisplayed();

// Habilitado/Desabilitado?
boolean habilitado = driver.findElement(By.id("botao")).isEnabled();

// Selecionado (checkbox/radio)?
boolean selecionado = driver.findElement(By.id("check")).isSelected();

// Existe?
try {
    driver.findElement(By.id("elem"));
    System.out.println("Elemento existe");
} catch (NoSuchElementException e) {
    System.out.println("Elemento não existe");
}

// Contar elementos
int quantidade = driver.findElements(By.className("item")).size();
```

---

## 📋 Dropdown (Select)

```java
import org.openqa.selenium.support.ui.Select;

// Selecionar por texto visível
Select select = new Select(driver.findElement(By.id("pais")));
select.selectByVisibleText("Brasil");

// Selecionar por valor (atributo value)
select.selectByValue("br");

// Selecionar por índice
select.selectByIndex(1);

// Obter selecionado
String selecionado = select.getFirstSelectedOption().getText();

// Obter todas as opções
List<WebElement> opcoes = select.getOptions();

// Desselecionar (multiple select)
select.deselectByVisibleText("Brasil");
select.deselectAll();
```

---

## ☑️ Checkbox e Radio

```java
// Marcar checkbox
WebElement check = driver.findElement(By.id("aceitar"));
if (!check.isSelected()) {
    check.click();
}

// Desmarcar checkbox
if (check.isSelected()) {
    check.click();
}

// Selecionar radio
driver.findElement(By.id("sexo-masculino")).click();

// Verificar se marcado
boolean marcado = driver.findElement(By.id("checkbox")).isSelected();
```

---

## ⏱️ Esperas (Waits)

```java
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

// Esperar estar visível
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("msg")));

// Esperar estar invisível (loading desaparecer)
wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("spinner")));

// Esperar estar clicável
wait.until(ExpectedConditions.elementToBeClickable(By.id("btn")));

// Esperar presença (sem precisar ver)
wait.until(ExpectedConditions.presenceOfElementLocated(By.id("elem")));

// Esperar URL contiver
wait.until(ExpectedConditions.urlContains("sucesso"));

// Esperar texto em elemento
wait.until(ExpectedConditions.textToBePresentInElement(
    driver.findElement(By.id("msg")), 
    "Sucesso"
));

// Custom - Esperar própria condição
wait.until(driver -> driver.findElement(By.id("msg")).getText().equals("Pronto"));
```

---

## 🎬 JavaScript (quando Selenium não consegue)

```java
import org.openqa.selenium.JavascriptExecutor;

// Clicar com JavaScript
WebElement elem = driver.findElement(By.id("btn"));
((JavascriptExecutor)driver).executeScript("arguments[0].click();", elem);

// Preencher com JavaScript
driver.findElement(By.id("field"));
driver.executeScript("arguments[0].value='texto';", By.id("field"));

// Scroll até elemento
driver.executeScript("arguments[0].scrollIntoView(true);", elem);

// Scroll para cima/baixo
driver.executeScript("window.scrollBy(0, 1000);");  // 1000px para baixo
driver.executeScript("window.scrollBy(0, -1000);"); // 1000px para cima

// Executar código (exemplo)
Object resultado = driver.executeScript("return document.title;");

// Remover atributo (anti-detecção)
driver.executeScript("Object.defineProperty(navigator, 'webdriver', {get: () => false});");
```

---

## 🖼️ Múltiplas Abas

```java
// Obter todas as abas
Set<String> abas = driver.getWindowHandles();

// Trocar para segunda aba
List<String> abas = new ArrayList<>(driver.getWindowHandles());
driver.switchTo().window(abas.get(1));

// Trocar para aba anterior
driver.switchTo().window(abas.get(0));

// Fechar aba atual
driver.close();

// Voltar para aba principal
driver.switchTo().window(abas.get(0));
```

---

## 🔲 Frames

```java
// Entrar em frame por ID
driver.switchTo().frame("id-frame");

// Entrar em frame por número
driver.switchTo().frame(0);

// Entrar em frame por elemento
driver.switchTo().frame(driver.findElement(By.id("iframe")));

// Sair de frame
driver.switchTo().defaultContent();
```

---

## 🎁 Upload de Arquivo

```java
// Simples
driver.findElement(By.id("arquivo")).sendKeys("C:\\caminho\\arquivo.pdf");

// Com URL relativa
String caminhoArquivo = new File("src/test/resources/docs/arquivo.pdf")
    .getAbsolutePath();
driver.findElement(By.id("arquivo")).sendKeys(caminhoArquivo);
```

---

## 🔍 Tirar Screenshot

```java
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import java.io.File;

// Tirar screenshot
File screenshot = ((TakesScreenshot)driver)
    .getScreenshotAs(OutputType.FILE);

// Salvar em local
File destino = new File("screenshots/teste_" + System.currentTimeMillis() + ".png");
FileUtils.copyFile(screenshot, destino);
```

---

## Page Object Completo (Template)

```java
package com.estudo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TemplatePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // 1. Definir URL
    public static final String URL = "https://exemplo.com";

    // 2. Definir localizadores
    private final By titulo = By.id("titulo");
    private final By botao = By.className("btn-principal");
    private final By mensagem = By.xpath("//div[@class='msg']");

    // 3. Construtor
    public TemplatePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // 4. Método para abrir
    public void abrir() {
        driver.get(URL);
    }

    // 5. Métodos de ação
    public void clicarBotao() {
        driver.findElement(botao).click();
    }

    // 6. Métodos de validação
    public String obterTitulo() {
        return driver.findElement(titulo).getText();
    }

    public boolean validarMensagem(String texto) {
        String msg = driver.findElement(mensagem).getText();
        return msg.contains(texto);
    }
}
```

---

**Copie e Cole!

