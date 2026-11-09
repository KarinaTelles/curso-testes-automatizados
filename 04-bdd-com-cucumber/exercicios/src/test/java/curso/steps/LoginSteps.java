package curso.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Então("deve ver a mensagem {string}")
    public void deveVerAMensagem(String esperada) {
        assertEquals(esperada, mensagem);
    }

    // TODO: os passos da feature bloqueio.feature ainda não existem.
    // Rode os testes: o Cucumber vai mostrar os passos indefinidos e sugerir
    // o esqueleto de cada método. Copie, ajuste os nomes e implemente.
}
