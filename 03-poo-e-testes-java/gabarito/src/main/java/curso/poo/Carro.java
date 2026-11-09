package curso.poo;

/** Carro é um Veiculo (herança) com atributos próprios, protegidos por encapsulamento. */
public class Carro extends Veiculo {
    private String marca;
    private String modelo;
    private int ano;

    public Carro() {
    }

    public Carro(String marca, String modelo, int ano) {
        setMarca(marca);
        setModelo(modelo);
        setAno(ano);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    /** O setter é o lugar certo para validar: o objeto nunca fica num estado inválido. */
    public void setAno(int ano) {
        if (ano < 1886) {
            throw new IllegalArgumentException("Ano inválido: " + ano);
        }
        this.ano = ano;
    }

    @Override
    public String ligar() {
        return "Carro ligado!";
    }

    @Override
    public String toString() {
        return "Carro: {marca='" + marca + "', modelo='" + modelo + "', ano=" + ano + "}";
    }
}
