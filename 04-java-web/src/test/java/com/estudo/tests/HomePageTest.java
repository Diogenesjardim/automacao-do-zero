package com.estudo.tests;

import com.estudo.base.BaseTest;
import com.estudo.pages.HomePage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Testes da página inicial.
 * Usa o Page Object HomePage para interagir com a página.
 */
public class HomePageTest extends BaseTest {

    @Test
    public void deveAbrirSiteEValidarPagina() {
        // Arrange
        HomePage homePage = new HomePage(driver);

        // Act
        homePage.abrir();

        // Assert
        assertTrue(homePage.estaCarregada(), "A página deveria estar visível");
    }

    @Test
    public void deveRetornarTituloDaPagina() {
        // Arrange
        HomePage homePage = new HomePage(driver);

        // Act
        homePage.abrir();
        String titulo = homePage.obterTitulo();

        // Assert
        assertTrue(titulo != null && !titulo.isEmpty(), "O título da página não deveria estar vazio");
    }
}
