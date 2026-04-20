package com.estudo.steps;

import com.estudo.pages.DatadogPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Step Definitions for the Datadog Continuous Testing E2E scenario.
 */
public class DatadogSteps {

    private WebDriver driver;
    private DatadogPage datadogPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        driver = new ChromeDriver(options);

        ((org.openqa.selenium.JavascriptExecutor) driver)
            .executeScript("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})");

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

        datadogPage = new DatadogPage(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // ── Given ─────────────────────────────────────────────────────────────────

    @Given("I open the Datadog Continuous Testing page")
    public void iOpenTheDatadogPage() {
        datadogPage.abrir();
    }

    // ── Then / And ────────────────────────────────────────────────────────────

    @Then("the page body should be visible")
    public void thePageBodyShouldBeVisible() {
        assertTrue(datadogPage.estaCarregada(),
            "The page body should be visible after loading");
    }

    @And("the URL should contain {string}")
    public void theUrlShouldContain(String domain) {
        assertTrue(datadogPage.urlContemDatadog(),
            "The URL should contain: " + domain);
    }

    @And("the browser tab title should not be empty")
    public void theBrowserTabTitleShouldNotBeEmpty() {
        String title = datadogPage.obterTitulo();
        assertNotNull(title, "Title should not be null");
        assertFalse(title.isEmpty(), "Browser tab title should not be empty");
        System.out.println("Title: " + title);
    }

    @And("the H1 heading should not be empty")
    public void theH1HeadingShouldNotBeEmpty() {
        String h1 = datadogPage.obterTituloPrincipal();
        assertNotNull(h1, "H1 should not be null");
        assertFalse(h1.isEmpty(), "H1 heading should not be empty");
        System.out.println("H1: " + h1);
    }

    @And("the navigation bar should be visible")
    public void theNavigationBarShouldBeVisible() {
        assertTrue(datadogPage.navBarEstaVisivel(),
            "The navigation bar should be visible");
    }
}
