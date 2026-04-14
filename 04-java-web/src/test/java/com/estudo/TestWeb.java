package com.estudo;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestWeb {

    @Test
    public void abrirSite() {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://codefloments.base44.app/");
        driver.manage().window().maximize();
        
        driver.quit();
    }
}