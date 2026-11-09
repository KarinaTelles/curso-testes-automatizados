package curso.desafios;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Desafio 3. Dado o faturamento diário de uma distribuidora (arquivo faturamento.json), calcule:
 *
 * <ul>
 *   <li>o menor valor de faturamento ocorrido em um dia do mês;</li>
 *   <li>o maior valor de faturamento ocorrido em um dia do mês;</li>
 *   <li>o número de dias em que o faturamento foi superior à média mensal.</li>
 * </ul>
 *
 * Dias sem faturamento (fins de semana e feriados, valor 0) devem ser ignorados no cálculo.
 */
public class Faturamento {
    private final List<Double> valoresComFaturamento;

    public Faturamento(List<Double> valoresDiarios) {
        this.valoresComFaturamento = valoresDiarios.stream().filter(valor -> valor > 0).toList();
        if (valoresComFaturamento.isEmpty()) {
            throw new IllegalArgumentException("Nenhum dia com faturamento");
        }
    }

    /** Lê um arquivo JSON no formato [{"dia": 1, "valor": 123.4}, ...] a partir do classpath. */
    public static Faturamento doJson(String recurso) {
        try (InputStream entrada = Faturamento.class.getResourceAsStream(recurso)) {
            if (entrada == null) {
                throw new IllegalArgumentException("Arquivo não encontrado: " + recurso);
            }
            JsonNode dias = new ObjectMapper().readTree(entrada);
            List<Double> valores = new ArrayList<>();
            for (JsonNode dia : dias) {
                valores.add(dia.get("valor").asDouble());
            }
            return new Faturamento(valores);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public double menor() {
        double menor = Double.MAX_VALUE;
        for (double valor : valoresComFaturamento) {
            menor = Math.min(menor, valor);
        }
        return menor;
    }

    public double maior() {
        // Cuidado: Double.MIN_VALUE é o menor número POSITIVO, não o mais negativo.
        double maior = -Double.MAX_VALUE;
        for (double valor : valoresComFaturamento) {
            maior = Math.max(maior, valor);
        }
        return maior;
    }

    public double media() {
        double soma = 0;
        for (double valor : valoresComFaturamento) {
            soma += valor;
        }
        return soma / valoresComFaturamento.size();
    }

    public int diasAcimaDaMedia() {
        double media = media();
        int dias = 0;
        for (double valor : valoresComFaturamento) {
            if (valor > media) {
                dias++;
            }
        }
        return dias;
    }
}
