package curso.desafios;

/**
 * Desafio 1. Observe o trecho:
 *
 * <pre>
 * int INDICE = 13, SOMA = 0, K = 0;
 * Enquanto K &lt; INDICE faça { K = K + 1; SOMA = SOMA + K; }
 * Imprimir(SOMA);
 * </pre>
 *
 * Ao final do processamento, qual será o valor de SOMA?
 */
public class Loop {
    public int somaAte(int indice) {
        int soma = 0;
        int k = 0;
        while (k < indice) {
            k = k + 1;
            soma = soma + k;
        }
        return soma;
    }
}
