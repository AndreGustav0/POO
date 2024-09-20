package org.example;

class OrdemServico {
    private Dispositivos dispositivo;
    private Tecnico tecnico;
    private boolean aprovado;
    private String status;

    public OrdemServico(Dispositivos dispositivo, Tecnico tecnico) {
        this.dispositivo = dispositivo;
        this.tecnico = tecnico;
        this.aprovado = false;
        this.status = "Orçamento não aprovado";
    }

    public void diagnosticar() {
        // A lógica de diagnóstico poderia ser mais complexa
        // Aqui estamos apenas definindo o custo
    }

    public int getCusto() {
        return dispositivo.getCusto();
    }

    public Dispositivos getDispositivo() {
        return dispositivo;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void aprovarOrcamento() {
        this.aprovado = true;
        this.status = "Em reparo";
    }

    public String getStatus() {
        return status;
    }
}