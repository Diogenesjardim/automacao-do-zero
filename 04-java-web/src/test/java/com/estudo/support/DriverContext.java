package com.estudo.support;

import org.openqa.selenium.WebDriver;

public final class DriverContext {
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    private DriverContext() {}

    public static WebDriver getDriver() {
        WebDriver driver = DRIVER.get();
        if (driver == null) {
            throw new IllegalStateException("WebDriver não foi inicializado. Verifique o Hook do Cucumber.");
        }
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DRIVER.set(driver);
    }

    public static void clear() {
        DRIVER.remove();
    }
}

