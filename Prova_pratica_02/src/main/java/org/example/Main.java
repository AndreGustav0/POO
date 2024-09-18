package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList <Workshop> listaWork = new ArrayList<>();
        ArrayList <Reuniao> listaReuniao = new ArrayList<>();
        ArrayList <EventoCorporativo> listaEvento = new ArrayList<>();

        String opc, opc2;

        System.out.println("\nGerenciador de eventos:");

        do {
            System.out.println("\n\n\t1 -- Adicionar um evento\n\t2 -- Ver lista de eventos\n\n\t0 -- Sair");
            opc = sc.nextLine();

            switch (opc){
                case "1":
                    opc2 = getOpc();

                    switch (opc2){
                        case "1":
                            listaWork.add(addWorkshop());
                            System.out.println("Workshop criado com sucesso!");
                            break;

                        case "2":
                            listaReuniao.add(addReuniao());
                            System.out.println("Reunião criada com sucesso!");
                            break;

                        case "3":
                            listaEvento.add(addEvento());
                            System.out.println("Evento corporativo criado com sucesso!");
                            break;
                    }
                    break;

                case "2":
                    opc2 = getOpc();

                    switch (opc2){
                        case "1":
                            for (Workshop work : listaWork) {
                                work.getInfo();
                            }
                            break;

                        case "2":
                            for (Reuniao  reun: listaReuniao) {
                                reun.getInfo();
                            }
                            break;

                        case "3":
                            for (EventoCorporativo eve : listaEvento) {
                                eve.getInfo();
                            }
                            break;
                    }
                    break;
            }
        }while(!opc.equals("0"));


        System.out.println("Volte sempre :D");
        sc.close();
    }

    //------------------------------------------------------------------------

    static String getOpc(){
        Scanner sc = new Scanner(System.in);
        String op;

        System.out.println("\nQue tipo de evento?\n\n\t1 -- Workshop\n\t2 -- Reunião\n\t3 -- Evento corporativo");

        do{
            op = sc.nextLine();
        }while(!op.equals("1") && !op.equals("2") && !op.equals("3"));

        return switch (op){
            case "1" -> "1";
            case "2" -> "2";
            case "3" -> "3";
            default -> "";
        };
    }

    //------------------------------------------------------------------------

    static Workshop addWorkshop(){
        Scanner sc = new Scanner(System.in);

        System.out.print("\nNome da Workshop: ");
        String nome = sc.nextLine();

        System.out.print("Data: ");
        String data = sc.nextLine();

        //TODO: criar função para adicionar participantes

        Workshop temp = new Workshop(nome, data);
        addParticipante(temp);

        return (temp);
    }

    //------------------------------------------------------------------------

    static void addParticipante(Workshop temp){
        Scanner sc = new Scanner(System.in);

        String nome;
        boolean cont;
        do{
            System.out.print("(Digite 'sair' para sair) Nome: ");
            nome =sc.nextLine();

            if(nome.equals("sair") || nome.equals("Sair")){
                break;      //Se o usuario digitar sair, esse if quebra o loop
            }

            //senão, ele adiciono o nome
            cont = temp.inscreverParticipante(nome);

        }while (cont);
    }

    //------------------------------------------------------------------------

    static Reuniao addReuniao(){
        Scanner sc = new Scanner(System.in);

        System.out.print("\nNome da Reunião: ");
        String nome = sc.nextLine();

        System.out.print("Data: ");
        String data = sc.nextLine();

        System.out.print("A reunião será privada? (s/n)");
        String priv;
        do{
            priv = sc.nextLine();
        }while(!priv.equals("s") && !priv.equals("S") && !priv.equals("n") && !priv.equals("N"));

        if (priv.equals("s") || priv.equals("S")){
            System.out.print("Senha: ");
            String senha = sc.nextLine();

            return(new Reuniao(nome, data, true, senha));
        }
        else{
            return (new Reuniao(nome, data, false, ""));
        }
    }
    //------------------------------------------------------------------------

    static EventoCorporativo addEvento(){
        Scanner sc = new Scanner(System.in);

        System.out.print("\nNome do Evento corporativo: ");
        String nome = sc.nextLine();

        System.out.print("Data: ");
        String data = sc.nextLine();

        System.out.print("Sala reservada: ");
        String sala = sc.nextLine();

        System.out.print("Área de refeições: ");
        String ref = sc.nextLine();

        return(new EventoCorporativo(nome, data, sala, ref));
    }
}