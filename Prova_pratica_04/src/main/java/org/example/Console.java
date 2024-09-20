package org.example;

public class Console extends Dispositivos{

    public Console(String problema) {
        super(problema);
    }

    @Override
    public int getCusto() {
        return 400;
    }

    @Override
    public int getPrazoMaximoDias() {
        return 10;
    }
}
