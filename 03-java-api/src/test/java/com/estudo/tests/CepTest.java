package com.estudo.tests;

import com.estudo.base.BaseTest;
import com.estudo.model.CepResponse;
import com.estudo.services.CepService;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * =============================================
 * TESTES DA API VIACEP — CepTest
 * =============================================
 *
 * O que é isso?
 * São os testes da API ViaCEP (https://viacep.com.br).
 * Cada método com @Test é um cenário de teste.
 *
 * Padrão usado: Arrange / Act / Assert (AAA)
 * - Arrange → prepara o que precisa
 * - Act     → faz a chamada na API
 * - Assert  → verifica o resultado
 */
public class CepTest extends BaseTest {

    // =============================================
    // CENÁRIO 1 — Status HTTP 200
    // =============================================
    /**
     * Verifica se a API retorna status 200 para um CEP válido.
     * Status 200 significa que a requisição foi bem-sucedida.
     */
    @Test
    public void deveRetornarStatus200ParaCepValido() {
        // Arrange
        CepService cepService = new CepService();
        String cep = "01310100"; // Avenida Paulista - SP

        System.out.println("\n===== CENÁRIO 1 — Status HTTP 200 =====");

        // Act
        Response response = cepService.buscarCepRaw(cep);

        // Assert
        assertEquals(200, response.getStatusCode(),
                "O status deveria ser 200 para um CEP válido");
    }

    // =============================================
    // CENÁRIO 2 — Dados do endereço corretos
    // =============================================
    /**
     * Verifica se os dados retornados correspondem ao CEP consultado.
     * Usa o Jackson para converter o JSON em objeto CepResponse.
     */
    @Test
    public void deveRetornarEnderecoCorretoParaCepValido() {
        // Arrange
        CepService cepService = new CepService();
        String cep = "01310100"; // Avenida Paulista - SP

        System.out.println("\n===== CENÁRIO 2 — Dados do endereço =====");

        // Act — o Jackson converte o JSON em objeto automaticamente
        CepResponse endereco = cepService.buscarCep(cep);

        // Assert — verifica os campos do endereço
        assertAll("Verificando dados do endereço",
                () -> assertEquals("01310-100",       endereco.getCep(),         "CEP incorreto"),
                () -> assertEquals("Avenida Paulista", endereco.getLogradouro(), "Logradouro incorreto"),
                () -> assertEquals("São Paulo",        endereco.getLocalidade(),  "Cidade incorreta"),
                () -> assertEquals("SP",               endereco.getUf(),          "UF incorreta")
        );
    }

    // =============================================
    // CENÁRIO 3 — CEP inválido retorna erro
    // =============================================
    /**
     * Verifica o comportamento da API quando o CEP não existe.
     * A API ViaCEP retorna status 200 com { "erro": true } nesse caso.
     */
    @Test
    public void deveRetornarErroParaCepInexistente() {
        // Arrange
        CepService cepService = new CepService();
        String cepInexistente = "00000000"; // CEP que não existe

        System.out.println("\n===== CENÁRIO 3 — CEP inexistente =====");

        // Act
        CepResponse resposta = cepService.buscarCep(cepInexistente);

        // Assert — a API retorna { "erro": true } para CEPs inexistentes
        assertTrue(resposta.isErro(),
                "A resposta deveria indicar erro para um CEP inexistente");
    }

    // =============================================
    // CENÁRIO 4 — CEP com formato inválido retorna 400
    // =============================================
    /**
     * Verifica se a API retorna status 400 (Bad Request) quando
     * o CEP tem um formato inválido (letras, menos de 8 dígitos, etc.).
     */
    @Test
    public void deveRetornarStatus400ParaCepComFormatoInvalido() {
        // Arrange
        CepService cepService = new CepService();
        String cepInvalido = "1234"; // formato inválido — menos de 8 dígitos

        System.out.println("\n===== CENÁRIO 4 — CEP formato inválido =====");

        // Act
        Response response = cepService.buscarCepRaw(cepInvalido);

        // Assert
        assertEquals(400, response.getStatusCode(),
                "O status deveria ser 400 para um CEP com formato inválido");
    }
}
