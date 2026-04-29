package com.estudo.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * =============================================
 * CLASSE BASE DE TESTES — BaseTest
 * =============================================
 *
 * O que é isso?
 * É uma classe "pai" que todos os testes herdam.
 * Ela cuida de abrir e fechar o navegador automaticamente.
 *
 * Por que usar?
 * - Evita repetir o código de setup em cada teste
 * - Garante que o navegador sempre abre antes e fecha depois
 *
 * Como funciona:
 * - @BeforeEach → roda ANTES de cada teste (abre o navegador)
 * - @AfterEach  → roda DEPOIS de cada teste (fecha o navegador)
 */
public class BaseTest {

    // O driver é o objeto que controla o navegador
    // "protected" permite que as classes filhas (os testes) usem ele
    protected WebDriver driver;

    /**
     * Executado antes de cada teste.
     * Configura e abre o Chrome automaticamente.
     */
    @BeforeEach
    public void setUp() {
        // WebDriverManager baixa o ChromeDriver certo para sua versão do Chrome
        // Você não precisa baixar nada manualmente!
        WebDriverManager.chromedriver().setup();

        // ChromeOptions permite configurar o comportamento do navegador
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // abre o Chrome maximizado

        // Cria o driver (abre o navegador)
        driver = new ChromeDriver(options);
    }

    /**
     * Executado depois de cada teste.
     * Fecha o navegador para liberar memória.
     */
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // fecha o navegador completamente
        }
    }
}
