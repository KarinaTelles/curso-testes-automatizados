package curso.poo;

/**
 * Classe base. Tudo que é comum a qualquer veículo fica aqui e é herdado pelas subclasses.
 *
 * <p>Os métodos devolvem texto em vez de imprimir, para que possam ser verificados por testes.
 */
public class Veiculo {
    private int velocidade;

    public String ligar() {
        return "Ligado!";
    }

    public String mover() {
        return "Andando...";
    }

    public String acelerar() {
        velocidade += 10;
        return "Acelerando...";
    }

    public String frear() {
        velocidade = 0;
        return "Parando...";
    }

    public int getVelocidade() {
        return velocidade;
    }
}
