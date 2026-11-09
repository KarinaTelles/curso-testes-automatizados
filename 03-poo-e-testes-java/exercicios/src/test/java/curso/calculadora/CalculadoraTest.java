package curso.calculadora;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculadoraTest {
    private Calculadora calculadora;

    // Roda antes de cada teste: cada um começa com uma calculadora nova.
    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }

    @Test
    @DisplayName("1 + 1 = 2")
    void somaDoisNumeros() {
        assertEquals(2, calculadora.somar(1, 1), "1 + 1 deveria ser 2");
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
        "0,    1,   1",
        "1,    2,   3",
        "49,  51, 100",
        "1,  100, 101"
    })
    void somaParametrizada(int primeiro, int segundo, int esperado) {
        assertEquals(esperado, calculadora.somar(primeiro, segundo),
                () -> primeiro + " + " + segundo + " deveria ser " + esperado);
    }

    @Test
    void subtrair() {
        // TODO: escreva um teste para subtrair, incluindo um resultado negativo
        fail("TODO: escreva este teste");
    }

    @Test
    void multiplicarPorZero() {
        assertEquals(0, calculadora.multiplicar(0, 99));
    }

    @Test
    @DisplayName("divisão é inteira e dividir por zero lança exceção")
    void dividir() {
        assertAll(
                () -> assertEquals(3, calculadora.dividir(7, 2)),
                () -> {
                    ArithmeticException erro = assertThrows(
                            ArithmeticException.class, () -> calculadora.dividir(10, 0));
                    assertEquals("Divisão por zero", erro.getMessage());
                });
    }
}
