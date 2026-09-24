package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JugadorTest {

    @Test
    void recibirCartas() {
        Jugador jugador = new Jugador("Ana");
        ArrayList<Carta> cartas = new ArrayList<>();
        cartas.add(new Carta(1, Figura.CORAZONES));
        cartas.add(new Carta(2, Figura.ESPADAS));

        jugador.recibirCartas(cartas);

        assertEquals(2, jugador.getMano().size(), "El jugador debe tener 2 cartas en la mano");
    }

    @Test
    void recibirCarta() {
        Jugador jugador = new Jugador("Carlos");
        Carta carta = new Carta(5, Figura.TREBOLES);

        jugador.recibirCarta(carta);

        assertEquals(1, jugador.getMano().size(), "El jugador debe tener 1 carta en la mano");
        assertEquals(carta, jugador.getMano().get(0), "La carta recibida debe estar en la mano");
    }

    @Test
    void devolverCartas() {
        Jugador jugador = new Jugador("María");
        jugador.recibirCarta(new Carta(10, Figura.DIAMANTES));
        jugador.recibirCarta(new Carta(11, Figura.ESPADAS));

        ArrayList<Carta> devueltas = jugador.devolverCartas(1);

        assertEquals(1, devueltas.size(), "Debe devolver 1 carta");
        assertEquals(1, jugador.getMano().size(), "Debe quedar 1 carta en la mano");
    }

    @Test
    void obtenerInformacion() {
        Jugador jugador = new Jugador("Ana");
        jugador.recibirCarta(new Carta(1, Figura.CORAZONES));

        String info = jugador.obtenerInformacion();

        assertTrue(info.contains("Ana"), "La información debe contener el nombre del jugador");
        assertTrue(info.contains("AS de CORAZONES"), "La información debe mostrar la carta correcta");
    }

    @Test
    void getMano() {
        Jugador jugador = new Jugador("Carlos");
        jugador.recibirCarta(new Carta(7, Figura.TREBOLES));

        ArrayList<Carta> mano = jugador.getMano();

        assertEquals(1, mano.size(), "La mano debe tener 1 carta");
        assertEquals(7, mano.get(0).getValor(), "La carta debe tener valor 7");
    }
}