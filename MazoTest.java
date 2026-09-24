package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

class MazoTest {

    @Test
    void inicializarMazo() {
        Mazo mazo = new Mazo();
        assertEquals(52, mazo.tamano(), "El mazo debe tener 52 cartas al inicializarse");
    }

    @Test
    void barajear() {
        Mazo mazo = new Mazo();
        ArrayList<Carta> antes = new ArrayList<>(mazo.repartirCartas(5));
        mazo.inicializarMazo(); // restablecer
        mazo.barajear();
        ArrayList<Carta> despues = new ArrayList<>(mazo.repartirCartas(5));
        // No garantizamos que cambie siempre, pero es muy probable
        assertNotEquals(antes.toString(), despues.toString(), "El orden debe cambiar al barajear");
    }

    @Test
    void repartirCartas() {
        Mazo mazo = new Mazo();
        ArrayList<Carta> mano = mazo.repartirCartas(5);
        assertEquals(5, mano.size(), "Debe repartir 5 cartas");
        assertEquals(47, mazo.tamano(), "El mazo debe quedar con 47 cartas");
    }

    @Test
    void agregarCarta() {
        Mazo mazo = new Mazo();
        Carta carta = new Carta(1, Figura.CORAZONES);
        mazo.agregarCarta(carta);
        assertTrue(mazo.tamano() > 52, "El mazo debe aumentar al agregar una carta");
    }

    @Test
    void agregarCartas() {
        Mazo mazo = new Mazo();
        ArrayList<Carta> nuevas = new ArrayList<>();
        nuevas.add(new Carta(2, Figura.ESPADAS));
        nuevas.add(new Carta(3, Figura.TREBOLES));
        mazo.agregarCartas(nuevas);
        assertTrue(mazo.tamano() > 52, "El mazo debe aumentar al agregar varias cartas");
    }

    @Test
    void sacarCarta() {
        Mazo mazo = new Mazo();
        Carta primera = mazo.sacarCarta();
        assertNotNull(primera, "Debe devolver una carta");
        assertEquals(51, mazo.tamano(), "El mazo debe tener 51 cartas después de sacar una");
    }

    @Test
    void tamano() {
        Mazo mazo = new Mazo();
        assertEquals(52, mazo.tamano(), "El tamaño inicial debe ser 52");
        mazo.sacarCarta();
        assertEquals(51, mazo.tamano(), "Después de sacar una carta debe ser 51");
    }

    @Test
    void mostrarPrimerasCartas() {
        Mazo mazo = new Mazo();
        // probamos que no lance exception.
        assertDoesNotThrow(() -> mazo.mostrarPrimerasCartas(5));
    }
}
