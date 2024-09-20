package org.example;

import java.util.ArrayList;
import java.util.List;


public class Time {
    private String nome;
    private String esporte;
    private List<Jogador> jogadores = new ArrayList<>();;

    public Time(String nome, String esporte) {
        this.nome = nome;
        this.esporte = esporte;
    }

    public String getNome() {
        return nome;
    }

    public String getEsporte() {
        return esporte;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    // Adicionar um jogador ao time
    public void adicionarJogador(Jogador jogador) {
        if (jogador.getEsporte().equalsIgnoreCase(this.esporte)) {
            jogadores.add(jogador);
        } else {
            System.out.println("O jogador não pode ser adicionado ao time, pois o esporte é diferente.");
        }
    }

    @Override
    public String toString() {
        return "Time: " + nome + " | Esporte: " + esporte + " | Jogadores: " + jogadores.size();
    }
}
