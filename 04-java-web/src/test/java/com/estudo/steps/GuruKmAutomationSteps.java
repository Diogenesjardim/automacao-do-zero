package com.estudo.steps;

import com.estudo.pages.GuruKmAutomationPage;
import com.estudo.support.DriverContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GuruKmAutomationSteps {

    private GuruKmAutomationPage page;

    @Given("que acesso a pagina de KM Automation do Guru")
    public void queAcessoAPaginaDeKmAutomationDoGuru() {
        page = new GuruKmAutomationPage(DriverContext.getDriver());
        page.abrir();
    }

    @When("aceito cookies se aparecer")
    public void aceitoCookiesSeAparecer() {
        page.aceitarCookiesSeAparecer();
    }

    @Then("devo ver o conteudo principal da pagina")
    public void devoVerOConteudoPrincipalDaPagina() {
        assertTrue(page.heroVisivel(), "Era esperado visualizar o conteúdo principal (hero) da página.");
    }

    @Then("o titulo da pagina deve estar preenchido")
    public void oTituloDaPaginaDeveEstarPreenchido() {
        String titulo = page.obterTitulo();
        assertFalse(titulo == null || titulo.trim().isEmpty(), "O título da página não deveria estar vazio.");
    }
}

