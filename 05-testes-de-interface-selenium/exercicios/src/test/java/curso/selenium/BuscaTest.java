package curso.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.Duration;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/** Teste direto, sem Page Object, para comparar com o LoginE2ETest. */
class BuscaTest extends BaseTest {
    private static final String URL = pagina("busca.html");

    private void buscar(String termo) {
        driver.get(URL);
        WebElement campo = driver.findElement(By.name("q"));
        campo.sendKeys(termo);
        campo.sendKeys(Keys.ENTER);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElementLocated(By.id("resumo"), "encontrado"));
    }

    @Test
    @DisplayName("busca simples - o título passa a conter o termo")
    void tituloContemOTermo() {
        buscar("Selenium");

        assertTrue(driver.getTitle().toLowerCase().contains("selenium"),
                "O título deveria conter o termo buscado");
    }

    @Test
    @DisplayName("a busca ignora maiúsculas e acentos")
    void resultados() {
        buscar("logica");

        List<String> resultados = driver.findElements(By.cssSelector("#resultados .resultado"))
                .stream().map(WebElement::getText).toList();
        assertEquals(List.of("Lógica com Python"), resultados);
    }

    @Test
    void semResultados() {
        // TODO: busque um termo que não existe e verifique que o resumo mostra
        // "Nenhum curso encontrado." e que a lista de resultados ficou vazia.
        fail("TODO: escreva este teste");
    }
}
