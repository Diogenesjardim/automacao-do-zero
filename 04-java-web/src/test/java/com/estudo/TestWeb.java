package com.estudo;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestWeb {

     // Anotação do TestNG indicando que esse método é um teste
    @Test
    public void abrirSite() throws InterruptedException {
        
         // Faz o download automático do driver do Chrome (chromedriver)
        // Não precisa baixar manualmente
        WebDriverManager.chromedriver().setup(); 
        
        // Cria uma instância do navegador Chrome
        WebDriver driver = new ChromeDriver();

        // Abre o site informado no navegador
        driver.get("https://codefloments.base44.app/");

        // Maximiza a janela do navegador
        driver.manage().window().maximize();

        // Maximiza a janela do navegador
        // Usado aqui para visualizar o navegador aberto
        Thread.sleep(5000); // espera 5 segundos
    
        // Fecha o navegador e encerra a sessão do WebDriver
        driver.quit();
    }
}