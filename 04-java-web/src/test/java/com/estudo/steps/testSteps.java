package com.estudo.steps;

import com.estudo.pages.MetodoPage;
import com.estudo.pages.NopCommercePage;
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
    private NopCommercePage nopPage;

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


    }

    // CT02====================== STEPS - NOPCOMMERCE ========================CT002

    @Given("que acesso a pagina NopCommerce")
    public void queAcessoAPaginaNopCommerce() {
        nopPage = new NopCommercePage(DriverContext.getDriver());
        nopPage.abrir();
    }

    @When("aceito cookies se aparecer na NopCommerce")
    public void aceitoCookiesSeAparecerNaNopCommerce() {
        nopPage.aceitarCookiesSeAparecer();
    }

    @Then("devo ver o logo na pagina NopCommerce")
    public void devoVerOLogoNaPaginaNopCommerce() {

    }

    @Then("devo ver o menu de navegacao na NopCommerce")
    public void devoVerOMenuDeNavegacaoNaNopCommerce() {

    }

    @Then("o titulo da pagina NopCommerce deve estar preenchido")
    public void oTituloDaPaginaNopCommercDeveEstarPreenchido() {

    }

    @Then("os produtos devem estar disponiveis para compra")
    public void osProdutosDevemEstarDisponiveisParaCompra() {

    }

    // ========================================================================

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
