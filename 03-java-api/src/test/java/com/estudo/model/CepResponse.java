package com.estudo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * =============================================
 * OBJETO DE RESPOSTA — CepResponse
 * =============================================
 *
 * O que é isso?
 * É uma classe que representa o JSON que a API ViaCEP retorna.
 * O Jackson converte automaticamente o JSON em um objeto desta classe.
 *
 * Exemplo de JSON retornado pela API:
 * {
 *   "cep": "01310-100",
 *   "logradouro": "Avenida Paulista",
 *   "bairro": "Bela Vista",
 *   "localidade": "São Paulo",
 *   "uf": "SP",
 *   "erro": true   ← só aparece quando o CEP não existe
 * }
 *
 * @JsonIgnoreProperties(ignoreUnknown = true)
 * Essa anotação diz: "se o JSON tiver campos que não estão aqui, ignore-os"
 * Assim não precisamos mapear todos os campos, só os que nos interessam.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CepResponse {

    // Campos que queremos usar nos testes
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;

    // Só aparece no JSON quando o CEP é inválido: { "erro": true }
    private Boolean erro;

    // =============================================
    // GETTERS — métodos para ler os valores
    // =============================================
    // O Jackson precisa dos getters para preencher o objeto

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

    public Boolean getErro() {
        return erro;
    }

    /**
     * Verifica se a resposta indica um CEP inválido.
     * A API retorna { "erro": true } quando o CEP não existe.
     *
     * @return true se o CEP for inválido
     */
    public boolean isErro() {
        return Boolean.TRUE.equals(erro);
    }
}
