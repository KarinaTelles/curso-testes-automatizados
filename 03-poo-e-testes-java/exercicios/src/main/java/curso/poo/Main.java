package curso.poo;

import java.util.List;

/** Mesmo roteiro da aula: criar objetos, chamar métodos e ver o polimorfismo em ação. */
public class Main {
    public static void main(String[] args) {
        Carro dolphin = new CarroEletrico("BYD", "Dolphin", 2023);
        Carro corollaCross = new Carro("Toyota", "Corolla Cross", 2022);

        System.out.println(dolphin);
        System.out.println(corollaCross);

        System.out.println(dolphin.ligar());
        System.out.println(dolphin.mover());
        System.out.println(dolphin.acelerar());
        System.out.println(dolphin.frear());

        // Polimorfismo: a mesma chamada, ligar(), tem um comportamento diferente para cada tipo.
        List<Veiculo> garagem = List.of(dolphin, new Moto(), new Veiculo());
        for (Veiculo veiculo : garagem) {
            System.out.println(veiculo.getClass().getSimpleName() + " -> " + veiculo.ligar());
        }
    }
}
