package org.example;

class Aluno extends Pessoa {

    public Aluno(String nome) {
        super(nome);
        this.limiteEmprestimos = 3; // limite de empréstimos
    }

    @Override
    public int getLimiteEmprestimos() {
        return limiteEmprestimos;
    }
}
