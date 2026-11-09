package curso.desafios;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Desafio 4. Dado o faturamento mensal por estado, calcule o percentual de representação
 * de cada estado no total:
 *
 * <pre>
 * SP - R$ 67.836,43   RJ - R$ 36.678,66   MG - R$ 29.229,88
 * ES - R$ 27.165,48   Outros - R$ 19.849,53
 * </pre>
 */
public class FaturamentoPorEstado {

    public double total(Map<String, Double> faturamento) {
        double total = 0;
        for (double valor : faturamento.values()) {
            total += valor;
        }
        return total;
    }

    /** Devolve, na mesma ordem da entrada, o percentual (0 a 100) de cada estado. */
    public Map<String, Double> percentuais(Map<String, Double> faturamento) {
        double total = total(faturamento);
        if (total == 0) {
            throw new IllegalArgumentException("O faturamento total não pode ser zero");
        }
        Map<String, Double> percentuais = new LinkedHashMap<>();
        for (Map.Entry<String, Double> estado : faturamento.entrySet()) {
            percentuais.put(estado.getKey(), estado.getValue() / total * 100);
        }
        return percentuais;
    }
}
