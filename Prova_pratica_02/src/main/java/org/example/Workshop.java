package org.example;

import java.util.ArrayList;

public class Workshop extends Evento{

    ArrayList <String> listaPart = new ArrayList<>();

    public Workshop(String nome, String data){
        super(nome, data);
    }

    public boolean inscreverParticipante(String participante){
        if (listaPart.size() < 30){
            listaPart.add(participante);
            System.out.println(participante + " adicionado ("+ (30-listaPart.size()) +" vagas restantes)");
            return true;
        }
        else {
            System.out.println("Lista cheia :(");
            return false;
        }
    }

    public void getInfo(){
        System.out.println("\n\n   Workshop: " + nome);
        System.out.println("Data: " + data);
        System.out.println("Participantes: ");
        for (String s : listaPart) {
            System.out.println("  -" + s);
        }
    }
}
