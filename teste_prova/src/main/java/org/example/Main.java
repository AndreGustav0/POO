package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Criando mídias
        Midia livro = new Livro("O Senhor dos Anéis", 2);
        Midia dvd = new Dvd("Matrix", 3);
        Midia ebook = new EBook("Aprendendo Java");

        // Criando usuários
        Pessoa aluno = new Aluno("Maria");
        Pessoa professor = new Professor("Carlos");

        // Realizando empréstimos
        System.out.println("Empréstimos:");
        System.out.println(aluno.emprestar(livro) ? "Empréstimo de livro bem-sucedido para " + aluno.getNome() : "Empréstimo de livro falhou.");
        System.out.println(aluno.emprestar(dvd) ? "Empréstimo de DVD bem-sucedido para " + aluno.getNome() : "Empréstimo de DVD falhou.");
        System.out.println(professor.emprestar(ebook) ? "Empréstimo de e-book bem-sucedido para " + professor.getNome() : "Empréstimo de e-book falhou.");

        // Devolvendo um livro
        aluno.devolver(livro);
        System.out.println("Livro devolvido por " + aluno.getNome());

        // Tentando emprestar novamente
        System.out.println(aluno.emprestar(livro) ? "Empréstimo de livro bem-sucedido para " + aluno.getNome() : "Empréstimo de livro falhou.");
    }
}