package org.example;

public class Jogador {
    private String nome;
    private String esporte;

    public Jogador(String nome, String esporte) {
        this.nome = nome;
        this.esporte = esporte;
    }

    public String getNome() {
        return nome;
    }

    public String getEsporte() {
        return esporte;
    }

    @Override
    public String toString() {
        return nome;
    }
}

