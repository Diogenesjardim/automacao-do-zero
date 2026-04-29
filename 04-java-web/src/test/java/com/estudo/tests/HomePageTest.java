package com.estudo.tests;

import com.estudo.base.BaseTest;
import com.estudo.pages.HomePage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * =============================================
 * TESTES DA PÁGINA INICIAL — HomePageTest
 * =============================================
 *
 * O que é isso?
 * São os testes em si. Cada método com @Test é um caso de teste.
 *
 * Repare que esta classe:
 * - Herda de BaseTest (não precisa abrir/fechar o navegador)
 * - Usa o Page Object HomePage (não acessa elementos diretamente)
 * - Fica focada apenas em VERIFICAR o comportamento da página
 *
 * Padrão usado nos testes: Arrange / Act / Assert (AAA)
 * - Arrange → prepara o que precisa
 * - Act     → executa a ação
 * - Assert  → verifica o resultado
 */
public class HomePageTest extends BaseTest {

    /**
     * Teste 1: Verifica se o site abre e a página carrega.
     */
    @Test
    public void deveAbrirSiteEValidarPagina() {
        // Arrange — cria o Page Object passando o driver
        HomePage homePage = new HomePage(driver);

        // Act — abre a página
        homePage.abrir();

        // Assert — verifica se a página está visível
        assertTrue(homePage.estaCarregada(), "A página deveria estar visível");
    }

    /**
     * Teste 2: Verifica se a página tem um título.
     */
    @Test
    public void deveRetornarTituloDaPagina() {
        // Arrange
        HomePage homePage = new HomePage(driver);

        // Act
        homePage.abrir();
        String titulo = homePage.obterTitulo();

        // Assert — o título não pode ser nulo nem vazio
        assertTrue(titulo != null && !titulo.isEmpty(), "O título da página não deveria estar vazio");
    }
}
