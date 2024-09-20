package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Campeonato {
    private List<Time> times;
    private Map<Time, Integer> tabelaPontos;

    public Campeonato() {
        this.times = new ArrayList<>();
        this.tabelaPontos = new HashMap<>();
    }

    // Metodo para adicionar um time ao campeonato
    public void adicionarTime(Time time) {
        if (!tabelaPontos.containsKey(time)) {
            times.add(time);
            tabelaPontos.put(time, 0); // Inicializa com 0 pontos
        } else {
            System.out.println("Time já adicionado ao campeonato.");
        }
    }

    // Retorna a lista de times no campeonato
    public List<Time> getTimes() {
        return times;
    }

    // Buscar time pelo nome
    public Time getTimeByName(String nome) {
        for (Time time : times) {
            if (time.getNome().equalsIgnoreCase(nome)) {
                return time;
            }
        }
        System.out.println("Time " + nome + " não encontrado.");
        return null;
    }

    // Registrar o resultado de uma partida e atualizar os pontos
    public void registrarPartida(Partida partida) {
        Time timeA = partida.getTimeA();
        Time timeB = partida.getTimeB();
        int resultadoA = partida.getResultadoA();
        int resultadoB = partida.getResultadoB();

        // Verifica se ambos os times participam do campeonato
        if (times.contains(timeA) && times.contains(timeB)) {
            // Lógica para pontuação baseada no esporte
            if (partida.getEsporte().equalsIgnoreCase("Futebol")) {
                if (resultadoA > resultadoB) {
                    atualizarPontos(timeA, 3); // Vitória do time A
                } else if (resultadoA < resultadoB) {
                    atualizarPontos(timeB, 3); // Vitória do time B
                } else {
                    atualizarPontos(timeA, 1); // Empate
                    atualizarPontos(timeB, 1);
                }
            } else if (partida.getEsporte().equalsIgnoreCase("Basquete")) {
                if (resultadoA > resultadoB) {
                    atualizarPontos(timeA, 2); // Vitória do time A
                } else {
                    atualizarPontos(timeB, 2); // Vitória do time B
                }
            } else if (partida.getEsporte().equalsIgnoreCase("Tênis")) {
                if (resultadoA > resultadoB) {
                    atualizarPontos(timeA, 1); // Vitória do time A
                } else {
                    atualizarPontos(timeB, 1); // Vitória do time B
                }
            } else {
                System.out.println("Esporte não suportado.");
            }
        } else {
            System.out.println("Um ou ambos os times não participam do campeonato.");
        }
    }

    // Método auxiliar para atualizar os pontos de um time
    private void atualizarPontos(Time time, int pontos) {
        tabelaPontos.put(time, tabelaPontos.get(time) + pontos);
    }

    // Obter a pontuação de um time
    public int getPontosTime(Time time) {
        return tabelaPontos.getOrDefault(time, 0);
    }
}
