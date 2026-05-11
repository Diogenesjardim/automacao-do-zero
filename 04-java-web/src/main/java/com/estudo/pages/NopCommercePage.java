package com.estudo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NopCommercePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public static final String URL = "https://demo.nopcommerce.com/";

    // Localizadores principais - NopCommerce
    private final By body = By.tagName("body");
    private final By cookieOkayButton = By.xpath("//button[contains(text(), 'OK') or contains(text(), 'Okay')]");
    private final By logoImage = By.className("header-logo");
    private final By searchBox = By.id("small-searchterms");
    private final By productList = By.className("product-grid");
    private final By headerMenu = By.className("header-menu");
    private final By pageTitle = By.xpath("//h1[@class='page-title']");

    public NopCommercePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    /**
     * Abre a página da NopCommerce
     */
    public void abrir() {
        driver.get(URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(body));
    }

    /**
     * Aceita cookies se o banner aparecer
     */
    public void aceitarCookiesSeAparecer() {
        try {
            WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(cookieOkayButton));
            if (btn.isDisplayed() && btn.isEnabled()) {
                btn.click();
            }
        } catch (TimeoutException | NoSuchElementException ignored) {
            // Cookie banner não está presente
        }
    }

    /**
     * Verifica se o logo está visível na página
     */
    public boolean logoVisivel() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(logoImage)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    /**
     * Obtém o título da página
     */
    public String obterTitulo() {
        return driver.getTitle();
    }

    /**
     * Verifica se o menu de navegação está visível
     */
    public boolean menuNavigacaoVisivel() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(headerMenu)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    /**
     * Verifica se existe lista de produtos na página
     */
    public boolean produtosDisponiveis() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(productList)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}
