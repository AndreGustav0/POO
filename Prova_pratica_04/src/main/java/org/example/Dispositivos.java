package org.example;

abstract class Dispositivos {

    protected String problema;

    public Dispositivos(String problema) {
        this.problema = problema;
    }

    public abstract int getCusto();
    public abstract int getPrazoMaximoDias();

}
