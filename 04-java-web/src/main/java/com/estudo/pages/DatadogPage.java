package com.estudo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page Object da landing page de Continuous Testing do Datadog.
 */
public class DatadogPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // URL limpa — sem parâmetros UTM/tracking que causam redirects em loop
    private static final String URL = "https://www.datadoghq.com/dg/synthetics/continuoustesting-b/";

    // Timeout explícito
    private static final int TIMEOUT_SEGUNDOS = 20;

    // Locators
    private final By body            = By.tagName("body");
    private final By tituloPrincipal = By.tagName("h1");
    private final By navBar          = By.cssSelector("nav, header, [class*='nav'], [class*='header']");

    public DatadogPage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SEGUNDOS));
    }

    /** Abre a página e aguarda o DOM estar pronto (document.readyState = complete) */
    public void abrir() {
        driver.get(URL);
        aguardarPaginaCarregar();
    }

    /** Aguarda o document.readyState ficar "complete" */
    private void aguardarPaginaCarregar() {
        wait.until((ExpectedCondition<Boolean>) wd ->
            ((JavascriptExecutor) wd)
                .executeScript("return document.readyState")
                .equals("complete")
        );
    }

    /** Verifica se o body está visível */
    public boolean estaCarregada() {
        WebElement bodyEl = wait.until(
            ExpectedConditions.visibilityOfElementLocated(body)
        );
        return bodyEl.isDisplayed();
    }

    /** Retorna o título da aba */
    public String obterTitulo() {
        return driver.getTitle();
    }

    /** Retorna o texto do H1 principal */
    public String obterTituloPrincipal() {
        WebElement h1 = wait.until(
            ExpectedConditions.visibilityOfElementLocated(tituloPrincipal)
        );
        return h1.getText();
    }

    /** Verifica se a URL contém o domínio do Datadog */
    public boolean urlContemDatadog() {
        wait.until(ExpectedConditions.urlContains("datadoghq.com"));
        return driver.getCurrentUrl().contains("datadoghq.com");
    }

    /** Verifica se a barra de navegação está presente */
    public boolean navBarEstaVisivel() {
        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(navBar)
        ).isDisplayed();
    }
}
