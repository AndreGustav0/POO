package org.example;


import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class CampeonatoTest {

    private Campeonato campeonato = new Campeonato();

    @Test
    public void testAdicionarTimeFutebol() {
        Time time = new Time("Time A", "Futebol");
        campeonato.adicionarTime(time);
        assertEquals(1, campeonato.getTimes().size());
    }

    @Test
    public void testAdicionarJogadorAoTime() {
        Time time = new Time("Time A", "Futebol");
        Jogador jogador = new Jogador("João", "Futebol");
        time.adicionarJogador(jogador);
        assertEquals(1, time.getJogadores().size());
        assertTrue(time.getJogadores().contains(jogador));
    }

    @Test
    public void testRegistrarPartidaFutebolVitoria() {
        Time timeA = new Time("Time A", "Futebol");
        Time timeB = new Time("Time B", "Futebol");
        campeonato.adicionarTime(timeA);
        campeonato.adicionarTime(timeB);

        Partida partida = new Partida(timeA, timeB, "Futebol");
        partida.setResultado(2, 1); // Time A vence

        campeonato.registrarPartida(partida);
        assertEquals(3, campeonato.getPontosTime(timeA));
        assertEquals(0, campeonato.getPontosTime(timeB));
    }

    @Test
    public void testRegistrarPartidaFutebolEmpate() {
        Time timeA = new Time("Time A", "Futebol");
        Time timeB = new Time("Time B", "Futebol");
        campeonato.adicionarTime(timeA);
        campeonato.adicionarTime(timeB);

        Partida partida = new Partida(timeA, timeB, "Futebol");
        partida.setResultado(1, 1); // Empate

        campeonato.registrarPartida(partida);
        assertEquals(1, campeonato.getPontosTime(timeA));
        assertEquals(1, campeonato.getPontosTime(timeB));
    }

    @Test
    public void testRegistrarPartidaBasqueteVitoria() {
        Time timeA = new Time("Time A", "Basquete");
        Time timeB = new Time("Time B", "Basquete");
        campeonato.adicionarTime(timeA);
        campeonato.adicionarTime(timeB);

        Partida partida = new Partida(timeA, timeB, "Basquete");
        partida.setResultado(80, 75); // Time A vence

        campeonato.registrarPartida(partida);
        assertEquals(2, campeonato.getPontosTime(timeA));
        assertEquals(0, campeonato.getPontosTime(timeB));
    }

    @Test
    public void testRegistrarPartidaTenisVitoria() {
        Jogador jogadorA = new Jogador("Jogador A", "Tênis");
        Jogador jogadorB = new Jogador("Jogador B", "Tênis");

        Partida partida = new Partida(jogadorA, jogadorB, "Tênis");
        partida.setResultado(2, 0); // Jogador A vence

        campeonato.registrarPartida(partida);
        assertEquals(1, campeonato.getPontosJogador(jogadorA));
        assertEquals(0, campeonato.getPontosJogador(jogadorB));
    }
}