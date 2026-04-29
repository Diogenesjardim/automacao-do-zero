package com.estudo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * =============================================
 * PAGE OBJECT - HomePage
 * =============================================
 *
 * O que é um Page Object?
 * É uma classe que representa uma página do site.
 * Ela guarda os elementos da página e as ações que
 * o usuário pode fazer nela.
 *
 * Por que usar?
 * - Organiza melhor o código
 * - Se um elemento mudar no site, você altera só aqui
 * - Os testes ficam mais fáceis de ler
 *
 * Estrutura básica de um Page Object:
 * 1. URL da página
 * 2. Locators (como encontrar os elementos)
 * 3. Métodos (ações que o usuário faz na página)
 */
public class HomePage {

    // O WebDriver é o "robô" que controla o navegador
    private final WebDriver driver;

    // O WebDriverWait faz o teste esperar um elemento aparecer
    // antes de tentar interagir com ele (evita erros de timing)
    private final WebDriverWait wait;

    // =============================================
    // 1. URL DA PÁGINA
    // =============================================
    private static final String URL = "https://codefloments.base44.app/";

    // =============================================
    // 2. LOCATORS — como encontrar os elementos
    // =============================================
    // By.tagName("body") encontra a tag <body> da página
    // Usamos isso para verificar se a página carregou
    private final By body = By.tagName("body");

    // =============================================
    // CONSTRUTOR
    // =============================================
    // Recebe o driver do teste e configura a espera de até 10 segundos
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // =============================================
    // 3. MÉTODOS — ações na página
    // =============================================

    /**
     * Abre a página no navegador.
     * Equivale a digitar a URL na barra de endereço.
     */
    public void abrir() {
        driver.get(URL);
    }

    /**
     * Verifica se a página carregou corretamente.
     * Espera até 10 segundos pelo elemento <body> aparecer.
     *
     * @return true se a página estiver visível, false caso contrário
     */
    public boolean estaCarregada() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(body)).isDisplayed();
    }

    /**
     * Retorna o título da página (o texto que aparece na aba do navegador).
     *
     * @return título da página
     */
    public String obterTitulo() {
        return driver.getTitle();
    }
}
