# 🖥️ Guia - Métodos de Desktops (NopCommerce)

## 📋 Resumo

Foram criados **6 métodos** na classe `NopCommercePage.java` para interagir com elementos da categoria **Desktops** do site NopCommerce.

---

## 🔧 Métodos Criados

### 1️⃣ **clicarBotaoDesktops()**
**Objetivo:** Clica no botão "Desktops" na categoria

**XPath:** `//*[@id='main']/div/aside/section[1]/div/ul/li[1]/ul/li[1]/a`

**Como usar:**
```java
nopPage.clicarBotaoDesktops();
```

**Em Feature File:**
```gherkin
When clico no botao Desktops
```

---

### 2️⃣ **produtoDesktopsExiste()**
**Objetivo:** Verifica se existe produto na categoria Desktops

**XPath:** `//*[@id='main']/div/section/div/div[2]/div[1]/div/div[1]/div/div/a/img`

**Retorna:** `boolean` (true se existe, false se não existe)

**Como usar:**
```java
boolean existe = nopPage.produtoDesktopsExiste();
assertTrue(existe);
```

**Em Feature File:**
```gherkin
Then devo ver produtos da categoria Desktops
```

---

### 3️⃣ **obterSrcProdutoDesktops()**
**Objetivo:** Obtém o URL da imagem do produto (atributo src)

**Retorna:** `String` com o caminho da imagem

**Como usar:**
```java
String urlImagem = nopPage.obterSrcProdutoDesktops();
System.out.println("URL da imagem: " + urlImagem);
```

**Em Feature File:**
```gherkin
Then o produto Desktops deve ter imagem carregada
```

---

### 4️⃣ **obterAltProdutoDesktops()**
**Objetivo:** Obtém a descrição da imagem (atributo alt)

**Retorna:** `String` com a descrição

**Como usar:**
```java
String descricao = nopPage.obterAltProdutoDesktops();
System.out.println("Descrição: " + descricao);
```

**Em Feature File:**
```gherkin
Then o produto Desktops deve ter descricao
```

---

### 5️⃣ **logoVisivel()** *(já existente)*
**Objetivo:** Verifica se o logo está visível

**Retorna:** `boolean`

---

### 6️⃣ **menuNavigacaoVisivel()** *(já existente)*
**Objetivo:** Verifica se o menu de navegação está visível

**Retorna:** `boolean`

---

## 📝 Cenários Completos de Uso

### Cenário 1: Simples
```gherkin
Scenario: Abrir página e clicar em Desktops
  Given que acesso a pagina NopCommerce
  When clico no botao Desktops
  Then devo ver produtos da categoria Desktops
```

### Cenário 2: Com Validação de Imagem
```gherkin
Scenario: Validar imagem do produto
  Given que acesso a pagina NopCommerce
  When clico no botao Desktops
  Then o produto Desktops deve ter imagem carregada
  And o produto Desktops deve ter descricao
```

### Cenário 3: Completo
```gherkin
Scenario: Fluxo completo de Desktops
  Given que acesso a pagina NopCommerce
  When aceito cookies se aparecer na NopCommerce
  And clico no botao Desktops
  Then devo ver o logo na pagina NopCommerce
  And devo ver produtos da categoria Desktops
  And o produto Desktops deve ter imagem carregada
```

---

## 💻 Código em Java (Sem BDD)

### Exemplo 1: Teste Simples
```java
NopCommercePage nopPage = new NopCommercePage(driver);
nopPage.abrir();
nopPage.aceitarCookiesSeAparecer();
nopPage.clicarBotaoDesktops();

assertTrue(nopPage.produtoDesktopsExiste());
```

### Exemplo 2: Com Validações
```java
NopCommercePage nopPage = new NopCommercePage(driver);
nopPage.abrir();
nopPage.clicarBotaoDesktops();

// Validar imagem
String src = nopPage.obterSrcProdutoDesktops();
assertTrue(src != null && !src.isEmpty());

// Validar descrição
String alt = nopPage.obterAltProdutoDesktops();
assertTrue(alt != null && !alt.isEmpty());
```

---

## 📊 Estrutura dos Elementos

### Elemento - Botão Desktops
```
//*[@id='main']
├── /div/aside/section[1]
│   └── /div/ul/li[1]
│       └── /ul/li[1]
│           └── /a  ⬅️ BOTÃO DESKTOPS
```

### Elemento - Imagem do Produto
```
//*[@id='main']
├── /div/section/div/div[2]
│   └── /div[1]/div/div[1]
│       └── /div/div/a
│           └── /img  ⬅️ IMAGEM DO PRODUTO
```

---

## 🎯 Passos para Implementar em Novo Cenário

### 1. Criar Feature File
```gherkin
Feature: Neue Funktionalität

  Scenario: Meu novo teste
    Given que acesso a pagina NopCommerce
    When clico no botao Desktops
    Then devo ver produtos da categoria Desktops
```

### 2. Adicionar Step (já feito!)
```java
@When("clico no botao Desktops")
public void clicoNoBotaoDesktops() {
    nopPage.clicarBotaoDesktops();
}
```

### 3. Executar Teste
```bash
mvn test -Dtest=RunCucumberTestNopCommerce
```

---

## ⚠️ Tratamento de Erros

### Se o elemento não for encontrado:
```java
// A exceção RuntimeException será lançada
try {
    nopPage.clicarBotaoDesktops();
} catch (RuntimeException e) {
    System.out.println("Erro: " + e.getMessage());
}
```

### Se o elemento não existir:
```java
// Retorna false
boolean existe = nopPage.produtoDesktopsExiste();
if (!existe) {
    System.out.println("Produto não encontrado!");
}
```

---

## 🔍 Como Encontrar Elementos com XPath

### Método 1: DevTools do Chrome
1. Abra o site: https://demo.nopcommerce.com/
2. Clique com botão direito no elemento
3. Selecione "Inspecionar" (Inspect)
4. Procure por `<a>`, `<img>`, etc.
5. Clique direito → "Copy" → "XPath"

### Método 2: Teste no Console
```javascript
// No DevTools do Chrome:
document.evaluate('//*[@id="main"]/div/aside/section[1]/div/ul/li[1]/ul/li[1]/a', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue
```

---

## 📚 Referências

- [Selenium WebDriver Documentation](https://www.selenium.dev/documentation/)
- [XPath Tutorials](https://www.w3schools.com/xml/xpath_intro.asp)
- [NopCommerce Demo](https://demo.nopcommerce.com/)

---

**Documentação criada em:** 2026-05-13  
**Versão:** 1.0

