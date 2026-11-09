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
        // TODO: hoje os dias com valor 0 entram no cálculo. Filtre-os (enunciado, item b).
        this.valoresComFaturamento = List.copyOf(valoresDiarios);
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
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public double maior() {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public double media() {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public int diasAcimaDaMedia() {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }
}
