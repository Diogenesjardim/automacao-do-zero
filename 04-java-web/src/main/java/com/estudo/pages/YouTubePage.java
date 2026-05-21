package com.estudo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YouTubePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public static final String URL = "https://www.youtube.com/";

    private final By body = By.tagName("body");
    private final By cookieOkayButton = By.xpath("//button[contains(., 'I agree') or contains(., 'Aceitar') or contains(., 'AGREE')]");
    private final By logoPrimary = By.cssSelector("ytd-topbar-logo-renderer");
    private final By logoFallback = By.cssSelector("a#logo");
    private final By searchInput = By.name("search_query");
    private final By searchInputFallback = By.cssSelector("input#search");

    public YouTubePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void abrir() {
        driver.get(URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(body));
    }

    public void aceitarCookiesSeAparecer() {
        By[] cookieLocators = new By[] {
                cookieOkayButton,
                By.xpath("//tp-yt-paper-button[contains(., 'I agree') or contains(., 'Accept') or contains(., 'Aceitar')]")
        };

        for (By locator : cookieLocators) {
            try {
                WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(locator));
                if (btn != null && btn.isDisplayed() && btn.isEnabled()) {
                    btn.click();
                    return;
                }
            } catch (Exception ignored) {
            }
        }
    }

    public boolean logoVisivel() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(logoPrimary)).isDisplayed();
        } catch (TimeoutException e) {
            try {
                return wait.until(ExpectedConditions.visibilityOfElementLocated(logoFallback)).isDisplayed();
            } catch (Exception ex) {
                return false;
            }
        }
    }

    public boolean campoBuscaVisivel() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput)).isDisplayed();
        } catch (TimeoutException e) {
            try {
                return wait.until(ExpectedConditions.visibilityOfElementLocated(searchInputFallback)).isDisplayed();
            } catch (Exception ex) {
                return false;
            }
        }
    }

    public String obterTitulo() {
        return driver.getTitle();
    }
}

