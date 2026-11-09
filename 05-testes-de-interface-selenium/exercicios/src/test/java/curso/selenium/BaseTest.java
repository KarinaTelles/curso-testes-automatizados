package curso.selenium;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Sobe um Chrome novo antes de cada teste e fecha depois, para que um teste nunca dependa
 * do estado deixado por outro.
 */
public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    void abrirNavegador() {
        ChromeOptions options = new ChromeOptions();
        // Headless é o padrão porque é assim que a CI roda. Para ver o navegador: -Dheadless=false
        if (!"false".equals(System.getProperty("headless"))) {
            options.addArguments("--headless=new");
        }
        options.addArguments("--window-size=1280,800", "--no-sandbox", "--disable-dev-shm-usage");
        // Se o Chrome/Chromium não estiver no lugar padrão, aponte com CHROME_BIN.
        String binario = System.getenv("CHROME_BIN");
        if (binario != null && !binario.isBlank()) {
            options.setBinary(binario);
        }
        // O Selenium Manager encontra (ou baixa) o chromedriver compatível sozinho.
        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @AfterEach
    void fecharNavegador() {
        if (driver != null) {
            driver.quit();
        }
    }

    /** As páginas de treino ficam em src/test/resources/site e são abertas direto do disco. */
    protected static String pagina(String arquivo) {
        URL url = BaseTest.class.getResource("/site/" + arquivo);
        if (url == null) {
            throw new IllegalArgumentException("Página não encontrada: " + arquivo);
        }
        try {
            return Path.of(url.toURI()).toUri().toString();
        } catch (URISyntaxException e) {
            throw new IllegalStateException(e);
        }
    }
}
