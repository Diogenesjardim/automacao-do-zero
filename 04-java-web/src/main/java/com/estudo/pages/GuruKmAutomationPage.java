package com.estudo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GuruKmAutomationPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public static final String URL =
            "https://www.getguru.com/solutions/km-automation?utm_term=&utm_campaign=&utm_source=adwords&utm_medium=ppc&hsa_acc=1249050873&hsa_cam=23540586447&hsa_grp=195925228791&hsa_ad=796640533662&hsa_src=g&hsa_tgt=dsa-2467058464930&hsa_kw=&hsa_mt=&hsa_net=adwords&hsa_ver=3&gad_source=1&gad_campaignid=23540586447&gbraid=0AAAAADjWwawzu7KUVwvUA7XXb5Qh-gW44&gclid=Cj0KCQjw2MbPBhCSARIsAP3jP9zWa9Ck9xFwF4Qk-SAQF2lrUsPaduCJO0OoNJsuDuuS1CAWTyTTD5QaAvb0EALw_wcB";

    private final By body = By.tagName("body");
    private final By cookieOkayButton = By.xpath("//button[normalize-space()='Okay' or normalize-space()='OK' or normalize-space()='Ok']");

    // Hero headings observed on the page; keeping flexible to avoid brittle locators
    private final By heroHeading = By.xpath(
            "//*[self::h1 or self::h2][contains(normalize-space(), 'Knowledge') and (contains(normalize-space(), 'maintains itself') or contains(normalize-space(), 'Management Automation'))]"
    );

    public GuruKmAutomationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void abrir() {
        driver.get(URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(body));
    }

    public void aceitarCookiesSeAparecer() {
        try {
            WebElement btn = driver.findElement(cookieOkayButton);
            if (btn.isDisplayed() && btn.isEnabled()) {
                btn.click();
            }
        } catch (NoSuchElementException ignored) {
            // banner not present
        }
    }

    public String obterTitulo() {
        return driver.getTitle();
    }

    public boolean heroVisivel() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(heroHeading)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}

