package org.example;

import java.util.ArrayList;
import java.util.List;

abstract class Pessoa {
    protected String nome;
    protected int limiteEmprestimos;
    protected List<Midia> emprestimos;

    public Pessoa(String nome) {
        this.nome = nome;
        this.emprestimos = new ArrayList<>();
    }

    public abstract int getLimiteEmprestimos();

    public boolean emprestar(Midia midia) {
        if (emprestimos.size() < getLimiteEmprestimos() && midia.emprestar()) {
            emprestimos.add(midia);
            return true;
        }
        return false;
    }

    public void devolver(Midia midia) {
        if (emprestimos.remove(midia)) {
            midia.devolver();
        }
    }

    public String getNome() {
        return nome;
    }
}

