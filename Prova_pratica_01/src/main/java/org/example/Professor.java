package org.example;

class Professor extends Pessoa {
    public Professor(String nome) {
        super(nome);
        this.limiteEmprestimos = 5; // limite de empréstimos
    }

    @Override
    public int getLimiteEmprestimos() {
        return limiteEmprestimos;
    }
}
