package curso.desafios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class DesafiosTest {

    @Nested
    @DisplayName("Desafio 1 - Loop")
    class DesafioLoop {
        @Test
        @DisplayName("com INDICE = 13, SOMA termina em 91")
        void somaAteTreze() {
            assertEquals(91, new Loop().somaAte(13));
        }

        @ParameterizedTest(name = "somaAte({0}) = {1}")
        @CsvSource({"0, 0", "1, 1", "4, 10", "100, 5050"})
        void outrosIndices(int indice, int esperado) {
            assertEquals(esperado, new Loop().somaAte(indice));
        }
    }

    @Nested
    @DisplayName("Desafio 2 - Fibonacci")
    class DesafioFibonacci {
        private final Fibonacci fibonacci = new Fibonacci();

        @Test
        void primeirosDezTermos() {
            assertEquals(List.of(0L, 1L, 1L, 2L, 3L, 5L, 8L, 13L, 21L, 34L), fibonacci.sequencia(10));
        }

        @Test
        void termoGrandeNaoEstoura() {
            assertEquals(12_586_269_025L, fibonacci.termo(50));
        }

        @ParameterizedTest
        @ValueSource(longs = {0, 1, 2, 21, 144})
        void pertence(long numero) {
            assertTrue(fibonacci.pertence(numero));
        }

        @ParameterizedTest
        @ValueSource(longs = {4, 6, 22, 100})
        void naoPertence(long numero) {
            assertFalse(fibonacci.pertence(numero));
        }

        @Test
        void posicaoNegativa() {
            assertThrows(IllegalArgumentException.class, () -> fibonacci.termo(-1));
        }
    }

    @Nested
    @DisplayName("Desafio 3 - Faturamento diário")
    class DesafioFaturamento {
        private static final double DELTA = 0.0001;

        @Test
        @DisplayName("lê o JSON e ignora os dias sem faturamento")
        void estatisticasDoArquivo() {
            Faturamento faturamento = Faturamento.doJson("/faturamento.json");

            assertEquals(373.7838, faturamento.menor(), DELTA);
            assertEquals(48924.2448, faturamento.maior(), DELTA);
            assertEquals(20865.3702, faturamento.media(), DELTA);
            assertEquals(10, faturamento.diasAcimaDaMedia());
        }

        @Test
        @DisplayName("um dia com valor zero não puxa a média para baixo")
        void zerosNaoEntramNaMedia() {
            Faturamento faturamento = new Faturamento(List.of(100.0, 0.0, 200.0, 0.0));

            assertEquals(150.0, faturamento.media(), DELTA);
            assertEquals(100.0, faturamento.menor(), DELTA);
            assertEquals(1, faturamento.diasAcimaDaMedia());
        }

        @Test
        void mesSemFaturamento() {
            assertThrows(IllegalArgumentException.class, () -> new Faturamento(List.of(0.0, 0.0)));
        }
    }

    @Nested
    @DisplayName("Desafio 4 - Faturamento por estado")
    class DesafioFaturamentoPorEstado {
        @Test
        void percentuaisDoEnunciado() {
            Map<String, Double> faturamento = new LinkedHashMap<>();
            faturamento.put("SP", 67836.43);
            faturamento.put("RJ", 36678.66);
            faturamento.put("MG", 29229.88);
            faturamento.put("ES", 27165.48);
            faturamento.put("Outros", 19849.53);

            FaturamentoPorEstado calculo = new FaturamentoPorEstado();
            Map<String, Double> percentuais = calculo.percentuais(faturamento);

            assertEquals(180759.98, calculo.total(faturamento), 0.001);
            assertEquals(37.53, percentuais.get("SP"), 0.01);
            assertEquals(20.29, percentuais.get("RJ"), 0.01);
            assertEquals(16.17, percentuais.get("MG"), 0.01);
            assertEquals(15.03, percentuais.get("ES"), 0.01);
            assertEquals(10.98, percentuais.get("Outros"), 0.01);
            assertEquals(100.0, percentuais.values().stream().mapToDouble(Double::doubleValue).sum(), 0.0001);
        }
    }

    @Nested
    @DisplayName("Desafio 5 - Inverter string")
    class DesafioInverteString {
        private final InverteString inverte = new InverteString();

        @ParameterizedTest(name = "\"{0}\" -> \"{1}\"")
        @CsvSource({"teste, etset", "abc, cba", "a, a", "ovo, ovo", "'', ''"})
        void inverte(String original, String esperado) {
            assertEquals(esperado, inverte.inverter(original));
        }

        @Test
        void textoComAcentos() {
            assertEquals("oãçnetA", inverte.inverter("Atenção"));
        }

        @Test
        void nuloNaoEPermitido() {
            assertThrows(IllegalArgumentException.class, () -> inverte.inverter(null));
        }
    }
}
