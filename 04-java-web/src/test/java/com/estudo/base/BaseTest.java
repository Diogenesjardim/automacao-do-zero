package com.estudo.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Classe base para todos os testes.
 * Gerencia o ciclo de vida do WebDriver (abrir/fechar navegador).
 */
public class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        // Evita detecção como bot (anti-automation fingerprint)
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        driver = new ChromeDriver(options);

        // Remove o flag navigator.webdriver que sites usam para detectar Selenium
        ((org.openqa.selenium.JavascriptExecutor) driver)
            .executeScript("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})");

        // Timeout de página: máximo 30s para carregar
        driver.manage().timeouts().pageLoadTimeout(java.time.Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(0));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
