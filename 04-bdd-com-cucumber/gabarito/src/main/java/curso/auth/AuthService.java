package curso.auth;

import java.util.HashMap;
import java.util.Map;

/**
 * Serviço de login bem simples, só para servir de alvo aos cenários BDD.
 * Em um sistema real os usuários viriam de um banco e a senha nunca ficaria em texto puro.
 */
public class AuthService {
    public static final int MAXIMO_DE_TENTATIVAS = 3;

    private final Map<String, String> senhas = new HashMap<>();
    private final Map<String, Integer> tentativasInvalidas = new HashMap<>();

    public AuthService() {
        senhas.put("admin", "1234");
    }

    public void cadastrar(String usuario, String senha) {
        senhas.put(usuario, senha);
    }

    public boolean login(String usuario, String senha) {
        if (usuario == null || senha == null || estaBloqueado(usuario)) {
            return false;
        }
        boolean senhaConfere = senha.equals(senhas.get(usuario));
        if (senhaConfere) {
            tentativasInvalidas.remove(usuario);
        } else {
            tentativasInvalidas.merge(usuario, 1, Integer::sum);
        }
        return senhaConfere;
    }

    public String mensagemPosLogin(String usuario, String senha) {
        if (login(usuario, senha)) {
            return "Login realizado com sucesso";
        }
        if (estaBloqueado(usuario)) {
            return "Usuário bloqueado";
        }
        return "Credenciais inválidas";
    }

    public boolean estaBloqueado(String usuario) {
        return tentativasInvalidas.getOrDefault(usuario, 0) >= MAXIMO_DE_TENTATIVAS;
    }
}
