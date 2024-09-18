package org.example;

abstract class Midia {
    protected String titulo;
    protected int numeroCopias;
    protected int copiasDisponiveis;

    public Midia(String titulo, int numeroCopias) {
        this.titulo = titulo;
        this.numeroCopias = numeroCopias;
        this.copiasDisponiveis = numeroCopias;
    }

    public abstract int getDuracaoEmprestimo(); // dias

    public String getTitulo() {
        return titulo;
    }

    public boolean emprestar() {
        if (copiasDisponiveis > 0) {
            copiasDisponiveis--;
            return true;
        }
        return false;
    }

    public void devolver() {
        if (copiasDisponiveis < numeroCopias) {
            copiasDisponiveis++;
        }
    }

    public boolean isDisponivel() {
        return copiasDisponiveis > 0;
    }
}
