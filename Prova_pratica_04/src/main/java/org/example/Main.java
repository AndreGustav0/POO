package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<OrdemServico> ordensServico = new ArrayList<>();

        Tecnico tecnicoSmartphone = new Tecnico("Carlos", "Smartphones");
        Tecnico tecnicoNotebook = new Tecnico("Ana", "Notebooks");
        Tecnico tecnicoConsole = new Tecnico("João", "Consoles");

        while (true) {
            System.out.println("Bem-vindo ao sistema de Assistência Técnica!");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Criar Ordem de Serviço para Smartphone");
            System.out.println("2. Criar Ordem de Serviço para Notebook");
            System.out.println("3. Criar Ordem de Serviço para Console");
            System.out.println("4. Diagnosticar Ordem de Serviço");
            System.out.println("5. Aprovar Orçamento");
            System.out.println("6. Ver Status da Ordem de Serviço");
            System.out.println("7. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            OrdemServico ordemServico; // Declaração da variável

            switch (opcao) {
                case 1:
                    System.out.print("Digite o problema do Smartphone: ");
                    String problemaSmartphone = scanner.nextLine();
                    ordemServico = new OrdemServico(new Smartphone(problemaSmartphone), tecnicoSmartphone);
                    ordensServico.add(ordemServico);
                    System.out.println("Ordem de Serviço criada para Smartphone.");
                    break;

                case 2:
                    System.out.print("Digite o problema do Notebook: ");
                    String problemaNotebook = scanner.nextLine();
                    ordemServico = new OrdemServico(new Notebook(problemaNotebook), tecnicoNotebook);
                    ordensServico.add(ordemServico);
                    System.out.println("Ordem de Serviço criada para Notebook.");
                    break;

                case 3:
                    System.out.print("Digite o problema do Console: ");
                    String problemaConsole = scanner.nextLine();
                    ordemServico = new OrdemServico(new Console(problemaConsole), tecnicoConsole);
                    ordensServico.add(ordemServico);
                    System.out.println("Ordem de Serviço criada para Console.");
                    break;

                case 4:
                    System.out.print("Digite o índice da Ordem de Serviço para diagnosticar (0 a " + (ordensServico.size() - 1) + "): ");
                    int indexDiagnostico = scanner.nextInt();
                    if (indexDiagnostico >= 0 && indexDiagnostico < ordensServico.size()) {
                        ordensServico.get(indexDiagnostico).diagnosticar();
                        System.out.println("Diagnóstico realizado. Custo: " + ordensServico.get(indexDiagnostico).getCusto());
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;

                case 5:
                    System.out.print("Digite o índice da Ordem de Serviço para aprovar (0 a " + (ordensServico.size() - 1) + "): ");
                    int indexAprovacao = scanner.nextInt();
                    if (indexAprovacao >= 0 && indexAprovacao < ordensServico.size()) {
                        ordensServico.get(indexAprovacao).aprovarOrcamento();
                        System.out.println("Orçamento aprovado.");
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;

                case 6:
                    System.out.print("Digite o índice da Ordem de Serviço para verificar status (0 a " + (ordensServico.size() - 1) + "): ");
                    int indexStatus = scanner.nextInt();
                    if (indexStatus >= 0 && indexStatus < ordensServico.size()) {
                        System.out.println("Status: " + ordensServico.get(indexStatus).getStatus());
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;

                case 7:
                    System.out.println("Saindo do sistema. Até logo!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
