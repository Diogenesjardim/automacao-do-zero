package com.estudo.hooks;

import com.estudo.support.DriverContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {

    @Before
    public void beforeScenario() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);
        DriverContext.setDriver(driver);
    }

    @After
    public void afterScenario() {
        try {
            WebDriver driver = DriverContext.getDriver();
            driver.quit();
        } finally {
            DriverContext.clear();
        }
    }
}

