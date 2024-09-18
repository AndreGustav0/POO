package org.example;

class Dvd extends Midia {
    public Dvd(String titulo, int numeroCopias) {
        super(titulo, numeroCopias);
    }

    @Override
    public int getDuracaoEmprestimo() {
        return 7; // dias
    }
}
