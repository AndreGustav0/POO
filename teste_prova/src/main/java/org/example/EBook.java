package org.example;

class EBook extends Midia {
    public EBook(String titulo) {
        super(titulo, Integer.MAX_VALUE); // e-book pode ter cópias infinitas
    }

    @Override
    public int getDuracaoEmprestimo() {
        return 21; // dias
    }
}
