package com.estudo.steps;

import com.estudo.pages.MetodoPage;
import com.estudo.support.DriverContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testSteps {

    @Before
    public void beforeScenario() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);
        DriverContext.setDriver(driver);
    }

    private MetodoPage page;

    @Given("que acesso a pagina de KM Automation do Guru")
    public void queAcessoAPaginaDeKmAutomationDoGuru() {
        page = new MetodoPage(DriverContext.getDriver());
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
    @After
    public void afterScenario() {
        try {
            WebDriver driver = DriverContext.getDriver();
            driver.quit();
        } finally {
            DriverContext.clear();
        }
    }
}

