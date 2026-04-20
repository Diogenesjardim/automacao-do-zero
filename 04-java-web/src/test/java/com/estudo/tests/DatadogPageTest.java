package com.estudo.tests;

import com.estudo.base.BaseTest;
import com.estudo.pages.DatadogPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes da landing page de Continuous Testing do Datadog.
 * Valida carregamento, título, URL e elementos principais.
 */
@DisplayName("Datadog - Continuous Testing Page")
public class DatadogPageTest extends BaseTest {

    private DatadogPage datadogPage;

    @BeforeEach
    public void inicializar() {
        datadogPage = new DatadogPage(driver);
        datadogPage.abrir();
    }

    @Test
    @DisplayName("Deve carregar a página com sucesso")
    public void deveCarregarAPagina() {
        // Assert
        assertTrue(datadogPage.estaCarregada(),
            "O body da página deveria estar visível após o carregamento");
    }

    @Test
    @DisplayName("Deve conter 'Datadog' na URL")
    public void deveConterDatadogNaUrl() {
        // Assert
        assertTrue(datadogPage.urlContemDatadog(),
            "A URL deveria conter 'datadoghq.com'");
    }

    @Test
    @DisplayName("Deve ter título da aba não vazio")
    public void deveTerTituloNaoVazio() {
        // Act
        String titulo = datadogPage.obterTitulo();

        // Assert
        assertNotNull(titulo, "O título não deveria ser nulo");
        assertFalse(titulo.isEmpty(), "O título da aba não deveria estar vazio");
        System.out.println("Título da página: " + titulo);
    }

    @Test
    @DisplayName("Deve exibir H1 com texto não vazio")
    public void deveExibirTituloPrincipal() {
        // Act
        String h1 = datadogPage.obterTituloPrincipal();

        // Assert
        assertNotNull(h1, "O H1 não deveria ser nulo");
        assertFalse(h1.isEmpty(), "O H1 da página não deveria estar vazio");
        System.out.println("H1 da página: " + h1);
    }

    @Test
    @DisplayName("Deve exibir a barra de navegação")
    public void deveExibirNavBar() {
        // Assert
        assertTrue(datadogPage.navBarEstaVisivel(),
            "A barra de navegação deveria estar visível");
    }
}
