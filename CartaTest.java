package org.example;

import static org.junit.jupiter.api.Assertions.*;

class CartaTest {

    @org.junit.jupiter.api.Test
    void getValor() {
        Carta carta = new Carta(10, Figura.CORAZONES);
        assertEquals(10, carta.getValor(), "El valor de la carta debe ser 10");
    }

    @org.junit.jupiter.api.Test
    void getTipo() {
        Carta carta = new Carta(5, Figura.ESPADAS);
        assertEquals(Figura.ESPADAS, carta.getTipo(), "La figura debe ser ESPADAS");
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        Carta carta1 = new Carta(1, Figura.CORAZONES);
        Carta carta2 = new Carta(11, Figura.TREBOLES);
        Carta carta3 = new Carta(12, Figura.DIAMANTES);
        Carta carta4 = new Carta(13, Figura.ESPADAS);
        Carta carta5 = new Carta(7, Figura.CORAZONES);

        assertEquals("[AS de CORAZONES]", carta1.toString());
        assertEquals("[JOTA de TREBOLES]", carta2.toString());
        assertEquals("[REINA de DIAMANTES]", carta3.toString());
        assertEquals("[REY de ESPADAS]", carta4.toString());
        assertEquals("[7 de CORAZONES]", carta5.toString());
    }
}