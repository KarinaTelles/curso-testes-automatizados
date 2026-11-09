package curso.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import curso.auth.AuthService;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

/**
 * Step definitions: a "cola" entre as frases em português da feature e o código Java.
 * O Cucumber cria uma instância nova desta classe para cada cenário.
 */
public class LoginSteps {
    private final AuthService auth = new AuthService();
    private String mensagem;

    @Dado("que existe o usuário {string} com a senha {string}")
    public void queExisteOUsuario(String usuario, String senha) {
        auth.cadastrar(usuario, senha);
    }

    @Dado("que o usuário está na tela de login")
    public void queOUsuarioEstaNaTelaDeLogin() {
        // Não há tela de verdade aqui: o serviço já foi criado. O passo existe para o
        // cenário contar a história completa para quem lê.
    }

    @Quando("informar o usuário {string} e a senha {string}")
    public void informarUsuarioESenha(String usuario, String senha) {
        mensagem = auth.mensagemPosLogin(usuario, senha);
    }

    @Quando("{string} errar a senha {int} vezes")
    public void errarASenha(String usuario, int vezes) {
        for (int i = 0; i < vezes; i++) {
            auth.login(usuario, "senha-errada");
        }
    }

    @Então("deve ver a mensagem {string}")
    public void deveVerAMensagem(String esperada) {
        assertEquals(esperada, mensagem);
    }

    @Então("ao informar o usuário {string} e a senha {string} deve ver a mensagem {string}")
    public void aoInformarDeveVer(String usuario, String senha, String esperada) {
        assertEquals(esperada, auth.mensagemPosLogin(usuario, senha));
    }

    @Então("o usuário {string} deve estar bloqueado")
    public void deveEstarBloqueado(String usuario) {
        assertTrue(auth.estaBloqueado(usuario));
    }

    @Então("o usuário {string} não deve estar bloqueado")
    public void naoDeveEstarBloqueado(String usuario) {
        assertFalse(auth.estaBloqueado(usuario));
    }
}
