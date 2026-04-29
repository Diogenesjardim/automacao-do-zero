# Java API — Testes com Rest Assured, Jackson e ViaCEP

Projeto de testes de API em Java usando Rest Assured, Jackson e JUnit 5.

---

## API utilizada

**ViaCEP** — API pública e gratuita para consulta de CEPs brasileiros.

- Site: [viacep.com.br](https://viacep.com.br)
- Endpoint: `GET https://viacep.com.br/ws/{cep}/json/`
- Exemplo de resposta:
```json
{
  "cep": "01310-100",
  "logradouro": "Avenida Paulista",
  "bairro": "Bela Vista",
  "localidade": "São Paulo",
  "uf": "SP"
}
```

---

## O que é o Jackson?

O **Jackson** é uma biblioteca que converte JSON em objeto Java (e vice-versa).

Sem Jackson, você precisaria ler o JSON manualmente:
```java
// Sem Jackson — trabalhoso
String logradouro = response.jsonPath().getString("logradouro");
```

Com Jackson, o JSON vira um objeto automaticamente:
```java
// Com Jackson — simples e organizado
CepResponse endereco = response.as(CepResponse.class);
String logradouro = endereco.getLogradouro();
```

---

## Estrutura do projeto

```
03-java-api/
├── src/test/java/com/estudo/
│   ├── base/
│   │   └── BaseTest.java          ← configura a URL base da API
│   ├── model/
│   │   └── CepResponse.java       ← objeto que representa o JSON da resposta
│   ├── services/
│   │   └── CepService.java        ← Service Object do endpoint ViaCEP
│   └── tests/
│       └── CepTest.java           ← 4 cenários de teste
│
└── pom.xml                        ← dependências do projeto
```

### Como cada arquivo se encaixa

```
BaseTest  (configura a URL base)
    ↑
CepTest  (os testes)  →  usa →  CepService  (Service Object)
                                     ↓
                              CepResponse  (objeto do JSON)
```

---

## Requisitos

- Java JDK 17 ou superior
- Apache Maven

---

## Como executar

1. Abra um terminal na pasta `03-java-api`
2. Rode:
   ```bash
   mvn test
   ```

---

## Os 4 cenários de teste

| # | Cenário | CEP usado | O que verifica |
|---|---|---|---|
| 1 | CEP válido → status 200 | `01310100` | Status HTTP da resposta |
| 2 | CEP válido → dados corretos | `01310100` | Logradouro, cidade, UF |
| 3 | CEP inexistente → erro | `00000000` | Campo `erro: true` no JSON |
| 4 | CEP formato inválido → status 400 | `1234` | Status HTTP 400 |

---

## Entendendo o código

### 1. Objeto de resposta (`CepResponse.java`)

```java
@JsonIgnoreProperties(ignoreUnknown = true) // ignora campos que não mapeamos
public class CepResponse {

    private String cep;
    private String logradouro;
    private String localidade;
    private String uf;
    private Boolean erro; // só aparece quando o CEP não existe

    // getters...
}
```

### 2. Service Object (`CepService.java`)

```java
public class CepService {

    public CepResponse buscarCep(String cep) {
        return given()
                .pathParam("cep", cep)
                .when()
                .get("/ws/{cep}/json/")
                .then()
                .extract()
                .as(CepResponse.class); // Jackson converte JSON → objeto
    }
}
```

### 3. Teste (`CepTest.java`)

```java
@Test
public void deveRetornarEnderecoCorretoParaCepValido() {
    // Arrange
    CepService cepService = new CepService();

    // Act
    CepResponse endereco = cepService.buscarCep("01310100");

    // Assert
    assertEquals("São Paulo", endereco.getLocalidade());
    assertEquals("SP", endereco.getUf());
}
```

---

## Observações

- O Maven baixa todas as dependências automaticamente.
- Certifique-se de ter `JAVA_HOME` configurado corretamente.
- A API ViaCEP é pública e não precisa de autenticação.
