package Cartas;

public class Carta {
    private String nome;
    private int velocidade;
    private int potencia;

    public Carta(String nome, int velocidade, int potencia) {
        this.nome = nome;
        this.velocidade = velocidade;
        this.potencia = potencia;
    }

    public String getNome() {
        return nome;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public int getPotencia() {
        return potencia;
    }
}
