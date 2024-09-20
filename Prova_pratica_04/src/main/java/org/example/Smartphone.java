package org.example;

public class Smartphone extends Dispositivos{

    public Smartphone(String problema) {
        super(problema);
    }

    @Override
    public int getCusto() {
        return 300;
    }

    @Override
    public int getPrazoMaximoDias() {
        return 3;
    }
}
