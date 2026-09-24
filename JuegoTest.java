package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class JuegoTest {

    @Test
    void main() {
        // redirigir la salida estándar a un buffer
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));

        // Ejecutar el main
        Juego.main(new String[]{});

        // Recuperar lo que se imprimió
        String output = salida.toString();

        // Verificar que contiene partes clave del flujo
        assertTrue(output.contains("CREANDO MAZO DE 52 CARTAS"), "Debe mostrar la creación del mazo");
        assertTrue(output.contains("CREANDO 3 JUGADORES"), "Debe mostrar la creación de jugadores");
        assertTrue(output.contains("REPARTEINDO A CADA JUGADOR"), "Debe mostrar el reparto de cartas");
        assertTrue(output.contains("ANA DEVUELVE 2 CARTAS AL MAZO"), "Debe mostrar la devolución de cartas");
        assertTrue(output.contains("BUSCANDO CARTA"), "Debe mostrar la búsqueda de carta");
    }
}