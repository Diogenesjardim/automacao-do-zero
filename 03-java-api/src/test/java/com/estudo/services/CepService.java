package com.estudo.services;

import com.estudo.model.CepResponse;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

/**
 * =============================================
 * SERVICE OBJECT — CepService
 * =============================================
 *
 * O que é isso?
 * Representa o endpoint da API ViaCEP.
 * Centraliza todas as chamadas HTTP para essa API.
 *
 * Endpoint usado: GET /ws/{cep}/json/
 *
 * Por que usar?
 * - Os testes ficam mais limpos e fáceis de ler
 * - Se o endpoint mudar, você altera só aqui
 */
public class CepService {

    // Formato do endpoint: /ws/{cep}/json/
    private static final String ENDPOINT = "/ws/{cep}/json/";

    /**
     * Busca o endereço pelo CEP e retorna o objeto CepResponse.
     *
     * O Jackson converte automaticamente o JSON em objeto Java.
     * Isso é feito pelo método .as(CepResponse.class)
     *
     * @param cep o CEP a ser consultado (ex: "01310100")
     * @return objeto CepResponse com os dados do endereço
     */
    public CepResponse buscarCep(String cep) {
        return given()
                .pathParam("cep", cep)
                .log().uri()                  // ← imprime a URL chamada
                .when()
                .get(ENDPOINT)
                .then()
                .log().body()                 // ← imprime o JSON da resposta
                .extract()
                .as(CepResponse.class);       // ← Jackson converte JSON → objeto
    }

    /**
     * Busca o CEP e retorna a Response bruta (sem converter).
     * Útil para verificar o status HTTP antes de converter o objeto.
     *
     * @param cep o CEP a ser consultado
     * @return Response com o resultado completo da requisição
     */
    public Response buscarCepRaw(String cep) {
        return given()
                .pathParam("cep", cep)
                .log().uri()                  // ← imprime a URL chamada
                .when()
                .get(ENDPOINT)
                .then()
                .log().status()               // ← imprime o status HTTP
                .log().body()                 // ← imprime o JSON da resposta
                .extract()
                .response();
    }
}
