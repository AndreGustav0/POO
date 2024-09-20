package org.example;

import java.util.Scanner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Campeonato campeonato = new Campeonato();

        System.out.println("Bem-vindo ao sistema de gerenciamento de campeonatos!");

        // Adicionando times
        System.out.println("Quantos times você quer adicionar?");
        int qtdeTimes = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        for (int i = 0; i < qtdeTimes; i++) {
            System.out.println("Digite o nome do time:");
            String nomeTime = scanner.nextLine();
            System.out.println("Digite o esporte do time:");
            String esporteTime = scanner.nextLine();

            Time time = new Time(nomeTime, esporteTime);
            campeonato.adicionarTime(time);
            System.out.println("Time " + nomeTime + " adicionado com sucesso.");
        }

        // Registrar partidas
        System.out.println("Registrar partidas");
        for (int i = 0; i < 2; i++) { // Exemplo para duas partidas
            System.out.println("Digite o nome do time A:");
            String nomeTimeA = scanner.nextLine();
            Time timeA = campeonato.getTimeByName(nomeTimeA);

            System.out.println("Digite o nome do time B:");
            String nomeTimeB = scanner.nextLine();
            Time timeB = campeonato.getTimeByName(nomeTimeB);

            if (timeA == null || timeB == null) {
                System.out.println("Um dos times não foi encontrado.");
                continue;
            }

            System.out.println("Digite o esporte da partida:");
            String esportePartida = scanner.nextLine();

            Partida partida = new Partida(timeA, timeB, esportePartida);

            System.out.println("Digite o resultado do time A:");
            int resultadoA = scanner.nextInt();

            System.out.println("Digite o resultado do time B:");
            int resultadoB = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            partida.setResultado(resultadoA, resultadoB);
            campeonato.registrarPartida(partida);

            System.out.println(partida);
        }

        // Exibir pontuações
        System.out.println("Pontuações dos times:");
        for (Time time : campeonato.getTimes()) {
            System.out.println(time.getNome() + ": " + campeonato.getPontosTime(time) + " pontos");
        }
    }
}
