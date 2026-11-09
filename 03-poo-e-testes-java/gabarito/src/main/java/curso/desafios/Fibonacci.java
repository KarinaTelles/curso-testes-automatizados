package curso.desafios;

import java.util.ArrayList;
import java.util.List;

/**
 * Desafio 2. Na sequência de Fibonacci cada termo é a soma dos dois anteriores:
 * 0, 1, 1, 2, 3, 5, 8, 13...
 */
public class Fibonacci {

    /** Devolve o termo de posição n, começando em termo(0) = 0. */
    public long termo(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("A posição não pode ser negativa");
        }
        if (n <= 1) {
            return n;
        }
        long anterior = 0;
        long atual = 1;
        for (int i = 2; i <= n; i++) {
            long proximo = anterior + atual;
            anterior = atual;
            atual = proximo;
        }
        return atual;
    }

    /** Devolve os primeiros {@code quantidade} termos. */
    public List<Long> sequencia(int quantidade) {
        List<Long> termos = new ArrayList<>();
        for (int i = 0; i < quantidade; i++) {
            termos.add(termo(i));
        }
        return termos;
    }

    /** Informa se o número pertence à sequência. */
    public boolean pertence(long numero) {
        for (int i = 0; ; i++) {
            long valor = termo(i);
            if (valor == numero) {
                return true;
            }
            if (valor > numero) {
                return false;
            }
        }
    }
}
