package curso.desafios;

/**
 * Desafio 5. Inverta os caracteres de uma string sem usar funções prontas como
 * StringBuilder.reverse().
 */
public class InverteString {
    public String inverter(String original) {
        if (original == null) {
            throw new IllegalArgumentException("O texto não pode ser nulo");
        }
        char[] invertida = new char[original.length()];
        for (int i = 0; i < original.length(); i++) {
            invertida[i] = original.charAt(original.length() - 1 - i);
        }
        return new String(invertida);
    }
}
