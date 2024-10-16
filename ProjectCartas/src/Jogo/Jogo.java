package Jogo;

import Cartas.Carta;
import Configuracao.ConfigCarta;
import Configuracao.CartaSeletor;
import Configuracao.Batalha;

import java.util.List;
import java.util.Scanner;

public class Jogo {
    public static void ComecaJogar() {
        ConfigCarta.criarCartasIniciais();

        Carta novaCarta = ConfigCarta.adicionarCarta("SLA", 1, 1);
        System.out.println("Carta adicionada: " + novaCarta.getNome());


        List<Carta> cartas = ConfigCarta.obterCartas();

        List<Carta> jogadorUmCartas;
        List<Carta> jogadorDoisCartas;
        do {
            System.out.println("Jogador 1");
            Batalha cartaSelector = new CartaSeletor();
            jogadorUmCartas = cartaSelector.selecionarCartas(cartas);

            Carta novaCarta2 = ConfigCarta.adicionarCarta("SLA2", 1, 1);
            System.out.println("Carta adicionada a jg 2: " + novaCarta.getNome());

            System.out.println("Jogador 2");
            jogadorDoisCartas = cartaSelector.selecionarCartas(cartas);

            if (jogadorUmCartas.equals(jogadorDoisCartas)) {
                System.out.println("Jogada repetida");
            } else {
                String resultado = batalha(jogadorUmCartas, jogadorDoisCartas);
                System.out.println(resultado);
            }

        } while (continuarGame());

    }

    public static String batalha(List<Carta> jogadorUm, List<Carta> jogadorDois) {
        Scanner scanner = new Scanner(System.in);
        int pontosJogadorUm = 0;
        int pontosJogadorDois = 0;

        int rodadas = Math.min(jogadorUm.size(), jogadorDois.size());

        for (int i = 0; i < rodadas; i++) {
            System.out.printf("Rodada %d:\n", i + 1);
            System.out.println("Escolha o atributo para comparação:" + jogadorUm.get(i).getNome());
            System.out.println("1. Potência");
            System.out.println("2. Velocidade");
            int atributoEscolhido = scanner.nextInt();
            System.out.println("Escolha o atributo para comparação:" + jogadorDois.get(i).getNome());
            System.out.println("1. Potência");
            System.out.println("2. Velocidade");
            int atributoEscolhido2 = scanner.nextInt();
            Carta cartaJogadorUm = jogadorUm.get(i);
            Carta cartaJogadorDois = jogadorDois.get(i);


            int valorJogadorUm = (atributoEscolhido == 1) ? cartaJogadorUm.getPotencia() : cartaJogadorUm.getVelocidade();
            int valorJogadorDois = (atributoEscolhido2 == 1) ? cartaJogadorDois.getPotencia() : cartaJogadorDois.getVelocidade();

            System.out.printf("Jogador 1 - %s: %d\n", cartaJogadorUm.getNome(), valorJogadorUm);
            System.out.printf("Jogador 2 - %s: %d\n", cartaJogadorDois.getNome(), valorJogadorDois);

            if (valorJogadorUm > valorJogadorDois) {
                System.out.println("Jogador 1 ganha esta rodada!");
                pontosJogadorUm++;
            } else if (valorJogadorDois > valorJogadorUm) {
                System.out.println("Jogador 2 ganha esta rodada!");
                pontosJogadorDois++;
            } else {
                System.out.println("Empate nesta rodada!");
            }

            System.out.println();
        }

        String resultado = "Resultado Final:\n" +
                "Jogador 1: " + pontosJogadorUm + " pontos\n" +
                "Jogador 2: " + pontosJogadorDois + " pontos\n";

        if (pontosJogadorUm > pontosJogadorDois) {
            resultado += "Jogador 1 vence!";


        } else if (pontosJogadorDois > pontosJogadorUm) {
            resultado += "Jogador 2 vence!";


        } else {
            resultado += "É um empate!";

        }
        return resultado;
    }

    static boolean continuarGame() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Deseja continuar no jogo?");
        System.out.println("1- Sim");
        System.out.println("2- Não");
        System.out.println("R: ");
        int resposta = sc.nextInt();

        if (resposta == 1) {
            return true;
        }
        System.out.println("End Game!");
        sc.close();
        return false;
    }

}
