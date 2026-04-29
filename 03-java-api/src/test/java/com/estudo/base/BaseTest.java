package com.estudo.base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;

/**
 * =============================================
 * CLASSE BASE DE TESTES — BaseTest
 * =============================================
 *
 * O que é isso?
 * É a classe "pai" que todos os testes herdam.
 * Ela configura a URL base da API uma única vez.
 *
 * Por que usar?
 * - Evita repetir a URL em cada teste
 * - Se a URL mudar, você altera só aqui
 */
public class BaseTest {

    // URL base da API ViaCEP
    private static final String BASE_URL = "https://viacep.com.br";

    /**
     * Executado antes de cada teste.
     * Configura a URL base e o tipo de resposta esperado (JSON).
     */
    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.requestSpecification = RestAssured.given()
                .accept(ContentType.JSON);
    }
}
