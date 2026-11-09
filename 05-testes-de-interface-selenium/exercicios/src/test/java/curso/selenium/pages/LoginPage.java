package curso.selenium.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page Object da tela de login. Os testes falam "digite o usuário", e só esta classe sabe
 * que o campo tem id="usuario". Se a página mudar, o conserto é num lugar só.
 */
public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By campoUsuario = By.id("usuario");
    private final By campoSenha = By.id("senha");
    private final By botaoEntrar = By.cssSelector("#form-login button[type='submit']");
    private final By mensagem = By.id("flash");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public LoginPage abrir(String url) {
        driver.get(url);
        return this;
    }

    public LoginPage digitarUsuario(String usuario) {
        WebElement campo = driver.findElement(campoUsuario);
        campo.clear();
        campo.sendKeys(usuario);
        return this;
    }

    public LoginPage digitarSenha(String senha) {
        // TODO: localize o campo de senha, limpe e digite a senha (veja digitarUsuario)
        throw new UnsupportedOperationException("TODO");
    }

    /** Envia o formulário esperando sucesso e devolve a próxima página. */
    public AreaSeguraPage entrarComSucesso() {
        driver.findElement(botaoEntrar).click();
        return new AreaSeguraPage(driver);
    }

    /** Envia o formulário esperando erro e continua na mesma página. */
    public LoginPage entrarComErro() {
        driver.findElement(botaoEntrar).click();
        return this;
    }

    /** Espera a mensagem aparecer, em vez de um Thread.sleep com tempo chutado. */
    public String mensagem() {
        // TODO: espere a mensagem ficar visível com o wait e devolva o texto dela.
        // Não use Thread.sleep: a página responde depois de um tempo variável.
        throw new UnsupportedOperationException("TODO");
    }
}
