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
    private final By headerMenu = By.className("header-menu");

    // Localizadores para Desktops e Produtos
    private final By btnDesktops = By.xpath("//aside//a[normalize-space()='Desktops']");
    private final By btnDesktopsFallback = By.xpath("//*[@id='main']/div/aside/section[1]/div/ul/li[1]/ul/li[1]/a");
    private final By produtoDesktops = By.cssSelector(".product-item img");
    private final By produtoDesktopsFallback = By.xpath("//*[@id='main']/div/section/div/div[2]/div[1]/div/div[1]/div/div/a/img");

    // Menu / navegação (Computers) - preferir linkText, fallback para XPath absoluto
    private final By menuComputers = By.linkText("Computers");
    private final By menuComputersFallback = By.xpath("/html/body/div[6]/div/nav/div[2]/div[1]/div[1]/a");
    private final By btnSubcategoria = By.xpath("/html/body/div[6]/div/nav/div[2]/div[3]/div[1]/a");

    public NopCommercePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }


    public void abrir() {
        driver.get(URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(body));
    }

    public void aceitarCookiesSeAparecer() {
        // Tenta uma série de localizadores comuns de cookie/aceitar
        By[] cookieLocators = new By[] {
                cookieOkayButton,
                By.xpath("//button[contains(translate(., 'ACEITAR', 'aceitar'), 'aceitar') or contains(translate(., 'ACCEPT', 'accept'), 'accept') or contains(., 'I agree') or contains(., 'Got it')]")
        };

        for (By locator : cookieLocators) {
            try {
                WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(locator));
                if (btn != null && btn.isDisplayed() && btn.isEnabled()) {
                    btn.click();
                    return;
                }
            } catch (Exception ignored) {
                // tentar próximo locator
            }
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

    // ...existing code...

    /**
     * Verifica se existe produto na página de Desktops
     */
    public boolean produtoDesktopsExiste() {
        try {
            WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(produtoDesktops));
            return el != null && el.isDisplayed();
        } catch (Exception e) {
            // tenta fallback absoluto
            try {
                WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(produtoDesktopsFallback));
                return el != null && el.isDisplayed();
            } catch (Exception ex) {
                return false;
            }
        }
    }

    /**
     * Obtém o atributo src da imagem do produto
     */
    public String obterSrcProdutoDesktops() {
        try {
            WebElement img = wait.until(ExpectedConditions.presenceOfElementLocated(produtoDesktops));
            return img.getAttribute("src");
        } catch (Exception e) {
            try {
                WebElement img = wait.until(ExpectedConditions.presenceOfElementLocated(produtoDesktopsFallback));
                return img.getAttribute("src");
            } catch (Exception ex) {
                return null;
            }
        }
    }

    /**
     * Obtém o atributo alt da imagem do produto
     */
    public String obterAltProdutoDesktops() {
        try {
            WebElement img = wait.until(ExpectedConditions.presenceOfElementLocated(produtoDesktops));
            return img.getAttribute("alt");
        } catch (Exception e) {
            try {
                WebElement img = wait.until(ExpectedConditions.presenceOfElementLocated(produtoDesktopsFallback));
                return img.getAttribute("alt");
            } catch (Exception ex) {
                return null;
            }
        }
    }

    // Helper genérico para clicar com espera
    private void safeClick(By locator) {
        try {
            WebElement el = wait.until(ExpectedConditions.elementToBeClickable(locator));
            el.click();
        } catch (TimeoutException e) {
            throw new RuntimeException("Elemento não foi encontrado/clicável: " + locator + " - " + e.getMessage(), e);
        }
    }

    /**
     * Clica no menu "Computers" (tenta linkText primeiro, depois fallback absoluto)
     */
    public void clicarMenuComputers() {
        try {
            safeClick(menuComputers);
        } catch (RuntimeException e) {
            safeClick(menuComputersFallback);
        }
    }

    /**
     * Clica no botão de subcategoria (fallback absoluto)
     */
    public void clicarBotaoSubcategoria() {
        safeClick(btnSubcategoria);
    }

    /**
     * Clica no botão Desktops (tenta seletor relativo, depois fallback absoluto)
     */
    public void clicarBotaoDesktops() {
        try {
            safeClick(btnDesktops);
        } catch (RuntimeException e) {
            safeClick(btnDesktopsFallback);
        }
    }
}