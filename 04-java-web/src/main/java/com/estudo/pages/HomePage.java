package com.estudo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page Object da página inicial do site.
 * Centraliza todos os elementos e ações da página.
 */
public class HomePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // URL da página
    private static final String URL = "https://codefloments.base44.app/";

    // Locators dos elementos da página
    private final By body = By.tagName("body");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Abre a página no navegador
    public void abrir() {
        driver.get(URL);
    }

    // Verifica se a página carregou
    public boolean estaCarregada() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(body)).isDisplayed();
    }

    // Retorna o título da página
    public String obterTitulo() {
        return driver.getTitle();
    }
}
