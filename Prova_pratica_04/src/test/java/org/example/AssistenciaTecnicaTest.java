package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AssistenciaTecnicaTest {

    OrdemServico ordemSmartphone;
    OrdemServico ordemNotebook;
    OrdemServico ordemConsole;


    Smartphone smartphone = new Smartphone("troca de tela");
    Notebook notebook = new Notebook("formatação de sistema");
    Console console = new Console("superaquecimento");

    Tecnico tecnicoSmartphone = new Tecnico("Carlos", "Smartphones");
    Tecnico tecnicoNotebook = new Tecnico("Ana", "Notebooks");
    Tecnico tecnicoConsole = new Tecnico("João", "Consoles");

    ordemSmartphone = new OrdemServico(smartphone, tecnicoSmartphone);
    ordemNotebook = new OrdemServico(notebook, tecnicoNotebook);
    ordemConsole = new OrdemServico(console, tecnicoConsole);

    @Test
    public void testarDiagnosticoECusto() {
        ordemSmartphone.diagnosticar();
        assertEquals(300, ordemSmartphone.getCusto());

        ordemNotebook.diagnosticar();
        assertEquals(200, ordemNotebook.getCusto());

        ordemConsole.diagnosticar();
        assertEquals(400, ordemConsole.getCusto());
    }

    @Test
    public void testarAprovacaoDeOrcamento() {
        assertFalse(ordemSmartphone.isAprovado());
        ordemSmartphone.aprovarOrcamento();
        assertTrue(ordemSmartphone.isAprovado());

        assertFalse(ordemNotebook.isAprovado());
        ordemNotebook.aprovarOrcamento();
        assertTrue(ordemNotebook.isAprovado());
    }

    @Test
    public void testarGerenciamentoDePrazos() {
        assertEquals(3, ordemSmartphone.getDispositivo().getPrazoMaximoDias());
        assertEquals(7, ordemNotebook.getDispositivo().getPrazoMaximoDias());
        assertEquals(10, ordemConsole.getDispositivo().getPrazoMaximoDias());
    }

    @Test
    public void testarAtribuicaoDeTecnicos() {
        assertEquals("Carlos", ordemSmartphone.getTecnico().getNome());
        assertEquals("Ana", ordemNotebook.getTecnico().getNome());
        assertEquals("João", ordemConsole.getTecnico().getNome());
    }

    @Test
    public void testarStatusOrdemDeServico() {
        assertEquals("Orçamento não aprovado", ordemSmartphone.getStatus());
        ordemSmartphone.aprovarOrcamento();
        assertEquals("Em reparo", ordemSmartphone.getStatus());
    }
}