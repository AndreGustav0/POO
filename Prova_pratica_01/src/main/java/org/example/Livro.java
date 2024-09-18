package org.example;

class Livro extends Midia {
    public Livro(String titulo, int numeroCopias) {
        super(titulo, numeroCopias);
    }

    @Override
    public int getDuracaoEmprestimo() {
        return 14; // dias
    }
}
