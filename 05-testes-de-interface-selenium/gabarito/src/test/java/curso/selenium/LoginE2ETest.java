package curso.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import curso.selenium.pages.AreaSeguraPage;
import curso.selenium.pages.LoginPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LoginE2ETest extends BaseTest {
    private static final String URL = pagina("login.html");

    @Test
    @DisplayName("login válido leva à área segura")
    void loginValido() {
        AreaSeguraPage areaSegura = new LoginPage(driver)
                .abrir(URL)
                .digitarUsuario("aluno")
                .digitarSenha("senha123")
                .entrarComSucesso();

        assertTrue(areaSegura.estaLogado(), "Deveria exibir a mensagem de sucesso ao entrar.");
        assertEquals("aluno", areaSegura.nomeExibido());
        assertEquals("Área segura - Loja de Treino", driver.getTitle());
    }

    @ParameterizedTest(name = "usuário \"{0}\" e senha \"{1}\" -> {2}")
    @CsvSource({
        "aluno, errada,   Usuário ou senha inválidos.",
        "outro, senha123, Usuário ou senha inválidos.",
        "'',    '',       Preencha usuário e senha."
    })
    void loginInvalido(String usuario, String senha, String mensagemEsperada) {
        String mensagem = new LoginPage(driver)
                .abrir(URL)
                .digitarUsuario(usuario)
                .digitarSenha(senha)
                .entrarComErro()
                .mensagem();

        assertEquals(mensagemEsperada, mensagem);
    }

    @Test
    @DisplayName("sair volta para a tela de login")
    void sair() {
        String mensagem = new LoginPage(driver)
                .abrir(URL)
                .digitarUsuario("aluno")
                .digitarSenha("senha123")
                .entrarComSucesso()
                .sair()
                .mensagem();

        assertEquals("Você saiu da área segura.", mensagem);
        assertEquals("Login - Loja de Treino", driver.getTitle());
    }
}
