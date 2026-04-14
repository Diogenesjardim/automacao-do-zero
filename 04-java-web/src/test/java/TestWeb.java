import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestWeb {

    @Test
    public void abrirSite() {

        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com");

        driver.quit();
    }
}