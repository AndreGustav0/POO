package org.example;

public class Partida {
    private Time timeA;
    private Time timeB;
    private String esporte;
    private int resultadoA;
    private int resultadoB;
    private int qtdeSubs;

    public Partida(Time timeA, Time timeB, String esporte) {
        this.timeA = timeA;
        this.timeB = timeB;
        this.esporte = esporte;
        this.qtdeSubs = 0;
    }

    // Definir os resultados da partida
    public void setResultado(int resultadoA, int resultadoB) {
        this.resultadoA = resultadoA;
        this.resultadoB = resultadoB;
    }

    // Registrar substituição para Futebol
    public void registrarSubstituicao() {
        if (esporte.equalsIgnoreCase("Futebol")) {
            if (qtdeSubs < 3) {
                qtdeSubs++;
                System.out.println("Substituição realizada. Total: " + qtdeSubs);
            } else {
                System.out.println("Número máximo de substituições alcançado.");
            }
        } else if (esporte.equalsIgnoreCase("Basquete")) {
            System.out.println("Substituição realizada no basquete (sem limite).");
        } else {
            System.out.println("Substituições não permitidas no esporte: " + esporte);
        }
    }

    public boolean podeFazerSubstituicao() {
        return qtdeSubs < 3 || !esporte.equalsIgnoreCase("Futebol");
    }

    public org.example.Time getTimeA() {
        return timeA;
    }

    public org.example.Time getTimeB() {
        return timeB;
    }

    public String getEsporte() {
        return esporte;
    }

    public int getResultadoA() {
        return resultadoA;
    }

    public int getResultadoB() {
        return resultadoB;
    }

    @Override
    public String toString() {
        return "Partida entre " + timeA.getNome() + " e " + timeB.getNome() + " | Esporte: " + esporte + " | Resultado: " + resultadoA + " - " + resultadoB;
    }
}
