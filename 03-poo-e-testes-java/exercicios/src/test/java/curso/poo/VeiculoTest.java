package curso.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class VeiculoTest {

    @Nested
    @DisplayName("Encapsulamento")
    class Encapsulamento {
        @Test
        @DisplayName("getters devolvem o que foi informado no construtor")
        void construtorPreencheAtributos() {
            Carro carro = new Carro("Toyota", "Corolla Cross", 2022);

            assertEquals("Toyota", carro.getMarca());
            assertEquals("Corolla Cross", carro.getModelo());
            assertEquals(2022, carro.getAno());
        }

        @Test
        @DisplayName("setAno recusa um ano impossível")
        void anoInvalido() {
            Carro carro = new Carro();
            IllegalArgumentException erro =
                    assertThrows(IllegalArgumentException.class, () -> carro.setAno(1500));
            assertEquals("Ano inválido: 1500", erro.getMessage());
        }

        @Test
        void toStringMostraOsAtributos() {
            Carro carro = new Carro("BYD", "Dolphin", 2023);
            assertEquals("Carro: {marca='BYD', modelo='Dolphin', ano=2023}", carro.toString());
        }
    }

    @Nested
    @DisplayName("Herança")
    class Heranca {
        @Test
        @DisplayName("Carro herda mover, acelerar e frear de Veiculo")
        void carroHerdaComportamento() {
            Carro carro = new Carro("Toyota", "Corolla Cross", 2022);

            assertEquals("Andando...", carro.mover());
            assertEquals("Acelerando...", carro.acelerar());
            carro.acelerar();
            assertEquals(20, carro.getVelocidade());
            assertEquals("Parando...", carro.frear());
            assertEquals(0, carro.getVelocidade());
        }

        @Test
        @DisplayName("CarroEletrico é um Carro e também é Eletrico")
        void carroEletricoTemDoisTipos() {
            CarroEletrico dolphin = new CarroEletrico("BYD", "Dolphin", 2023);

            assertInstanceOf(Carro.class, dolphin);
            assertInstanceOf(Eletrico.class, dolphin);
            assertEquals("Carregando...", dolphin.carregar());
        }
    }

    @Nested
    @DisplayName("Polimorfismo")
    class Polimorfismo {
        @Test
        @DisplayName("ligar() se comporta de acordo com o tipo real do objeto")
        void ligarDependeDoTipo() {
            List<Veiculo> garagem = List.of(
                    new Veiculo(), new Carro("BYD", "Dolphin", 2023), new Moto());

            List<String> mensagens = garagem.stream().map(Veiculo::ligar).toList();

            assertEquals(List.of("Ligado!", "Carro ligado!", "Moto ligada!"), mensagens);
        }
    }
}
