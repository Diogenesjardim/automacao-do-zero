package com.estudo.steps;

import com.estudo.pages.MetodoPage;
import com.estudo.pages.NopCommercePage;
import com.estudo.pages.YouTubePage;
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
    private YouTubePage ytPage;

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

    // CT02====================== STEPS - NOPCOMMERCE ========================CT002

    @Given("que acesso a pagina NopCommerce")
    public void queAcessoAPaginaNopCommerce() {
        nopPage = new NopCommercePage(DriverContext.getDriver());
        nopPage.abrir();
    }

    @Given("que acesso a pagina YouTube")
    public void queAcessoAPaginaYouTube() {
        ytPage = new YouTubePage(DriverContext.getDriver());
        ytPage.abrir();
    }

    @When("aceito cookies se aparecer na NopCommerce")
    public void aceitoCookiesSeAparecerNaNopCommerce() {
        nopPage.aceitarCookiesSeAparecer();
    }

    @When("aceito cookies se aparecer no YouTube")
    public void aceitoCookiesSeAparecerNoYouTube() {
        ytPage.aceitarCookiesSeAparecer();
    }




    @Then("devo ver o logo na pagina NopCommerce")
    public void devoVerOLogoNaPaginaNopCommerce() {
        assertTrue(nopPage.logoVisivel(), "Era esperado visualizar o logo da página NopCommerce.");
    }

    @Then("devo ver o logo no YouTube")
    public void devoVerOLogoNoYouTube() {
        assertTrue(ytPage.logoVisivel(), "Era esperado visualizar o logo do YouTube.");
    }

    @Then("devo ver o menu de navegacao na NopCommerce")
    public void devoVerOMenuDeNavegacaoNaNopCommerce() {
        assertTrue(nopPage.menuNavigacaoVisivel(), "Era esperado visualizar o menu de navegação da NopCommerce.");
    }

    @Then("devo ver o campo de busca no YouTube")
    public void devoVerOCampoDeBuscaNoYouTube() {
        assertTrue(ytPage.campoBuscaVisivel(), "Era esperado ver o campo de busca no YouTube.");
    }

    @Then("o titulo da pagina NopCommerce deve estar preenchido")
    public void oTituloDaPaginaNopCommercDeveEstarPreenchido() {
        String titulo = nopPage.obterTitulo();
        assertFalse(titulo == null || titulo.trim().isEmpty(), "O título da página NopCommerce não deveria estar vazio.");
    }

    @Then("o titulo da pagina YouTube deve estar preenchido")
    public void oTituloDaPaginaYouTubeDeveEstarPreenchido() {
        String titulo = ytPage.obterTitulo();
        assertFalse(titulo == null || titulo.trim().isEmpty(), "O título da página YouTube não deveria estar vazio.");
    }

    @When("clico no botao Desktops")
    public void clicoNoBotaoDesktops() {
        nopPage.clicarBotaoDesktops();
    }

    @When("clico no menu Computers")
    public void clicoNoMenuComputers() {
        nopPage.clicarMenuComputers();
    }

    @Then("devo ver produtos da categoria Desktops")
    public void devoVerProdutosDaCategoriaDesktops() {
        assertTrue(nopPage.produtoDesktopsExiste(), "Era esperado visualizar produtos da categoria Desktops.");
    }

    @Then("o produto Desktops deve ter imagem carregada")
    public void oProdutoDesktopsDeveTermImagemCarregada() {
        String src = nopPage.obterSrcProdutoDesktops();
        assertFalse(src == null || src.trim().isEmpty(), "A imagem do produto Desktops não deveria estar vazia.");
    }

    @Then("o produto Desktops deve ter descricao")
    public void oProdutoDesktopsDeveTermDescricao() {
        String alt = nopPage.obterAltProdutoDesktops();
        assertFalse(alt == null || alt.trim().isEmpty(), "O produto Desktops não deveria ter descrição vazia.");
    }

    // ========================================================================






    @After
    public void afterScenario() {
        WebDriver driver = null;
        try {
            try {
                driver = DriverContext.getDriver();
            } catch (IllegalStateException ignored) {
                driver = null;
            }
            if (driver != null) {
                driver.quit();
            }
        } finally {
            DriverContext.clear();
        }
    }
}