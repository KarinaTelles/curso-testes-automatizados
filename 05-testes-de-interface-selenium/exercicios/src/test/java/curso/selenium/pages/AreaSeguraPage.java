package curso.selenium.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AreaSeguraPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By areaSegura = By.id("area-segura");
    private final By nomeUsuario = By.id("nome-usuario");
    private final By mensagem = By.id("flash");
    private final By botaoSair = By.id("sair");

    public AreaSeguraPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public boolean estaLogado() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(areaSegura));
        return driver.findElement(mensagem).getText().contains("Você entrou na área segura!");
    }

    public String nomeExibido() {
        return driver.findElement(nomeUsuario).getText();
    }

    public LoginPage sair() {
        wait.until(ExpectedConditions.elementToBeClickable(botaoSair)).click();
        return new LoginPage(driver);
    }
}
