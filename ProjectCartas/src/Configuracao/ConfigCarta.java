package Configuracao;

import Cartas.Carta;

import java.util.ArrayList;
import java.util.List;

public class ConfigCarta{

    private static List<Carta> cartas = new ArrayList<>();

    public static Carta adicionarCarta(String nome, int velocidade, int potencia) {
        Carta novaCarta = new Carta(nome, velocidade, potencia);
        cartas.add(novaCarta);
        return novaCarta;
    }

    public static void criarCartasIniciais() {
        adicionarCarta("Mustang GT perfomece ", 250, 480);
        adicionarCarta("lamborghini huracan", 325, 640 );
        adicionarCarta("Cayman GT4 ", 315, 500);
        adicionarCarta("BMW M3 Competion", 250, 180);
    }

    public static List<Carta> obterCartas() {
        return new ArrayList<>(cartas);
    }



}
