package org.example;

public class Notebook extends Dispositivos{

    public Notebook(String problema) {
        super(problema);
    }

    @Override
    public int getCusto() {
        return 200;
    }

    @Override
    public int getPrazoMaximoDias() {
        return 7;
    }
}
