package curso.poo;

/** Herda tudo de Carro e ainda cumpre o contrato da interface Eletrico. */
public class CarroEletrico extends Carro implements Eletrico {

    public CarroEletrico(String marca, String modelo, int ano) {
        super(marca, modelo, ano);
    }

    @Override
    public String carregar() {
        return "Carregando...";
    }
}
