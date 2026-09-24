package org.example;

import java.util.ArrayList;

public class Juego {
    public static void main(String[] args){
        // creacion del mazo de 52 cartas
        System.out.println("CREANDO MAZO DE 52 CARTAS");
        Mazo mazo = new Mazo();
        System.out.println("\nMazo creado con " + mazo.tamano() + " cartas");
        // mostrando las primeras 5 cartas sin barajar
        System.out.println("\nMOSTRANDO PRIMERAS 5 CARTAS DEL MAZO SIN BARAJAR");
        mazo.mostrarPrimerasCartas(5);
        System.out.println("\nBARAJANDO MAZO...");
        mazo.barajear();
        System.out.println("\n¡Mazo barajado!");
        System.out.println("\nMOSTRANDO PRIMERAS 5 CARTAS DEL MAZO DESPUES DE BARAJAR");
        mazo.mostrarPrimerasCartas(5);
        // barajando mazo
        System.out.println("\nCREANDO 3 JUGADORES");
        Jugador jugador1 = new Jugador("Ana");
        Jugador jugador2 = new Jugador("Carlos");
        Jugador jugador3 = new Jugador("Maria");

        System.out.println("Jugador 1: " + jugador1.nombre);
        System.out.println("Jugador 2: " + jugador2.nombre);
        System.out.println("Jugador 3: " + jugador3.nombre);
        // repartiendo 5 cartas a cada jugador
        System.out.println("\nREPARTEINDO A CADA JUGADOR");
        System.out.println("Repartiendo... ");
        jugador1.recibirCartas(mazo.repartirCartas(5));
        jugador2.recibirCartas(mazo.repartirCartas(5));
        jugador3.recibirCartas(mazo.repartirCartas(5));
        System.out.println("¡Listo!");
        // mostrando cartas de cada jugador
        System.out.println("\nMOSTRANDO CARTAS DE CADA JUGADOR:");
        System.out.println(jugador1.obtenerInformacion());
        System.out.println(jugador2.obtenerInformacion());
        System.out.println(jugador3.obtenerInformacion());
        // mostrando el estado del mazo
        System.out.println("\nCARTAS RESTANTES EN EL MAZO:");
        System.out.println("Quedan " + mazo.tamano() + " cartas en el mazo");
        System.out.print("Primeras 5 cartas del mazo: ");
        mazo.mostrarPrimerasCartas(5);
        // devolviendo cartas al mazo
        System.out.println("\nANA DEVUELVE 2 CARTAS AL MAZO");
        ArrayList<Carta> cartasDevueltas = jugador1.devolverCartas(2);
        for(Carta carta : cartasDevueltas){
            mazo.agregarCarta(carta);
        }

        System.out.println("\nCARTAS DE ANA DESPUÉS DE DEVOLVER:");
        System.out.println(jugador1.obtenerInformacion() + "\n");

        System.out.println("\nMAZO DESPUÉS DE RECIBIR CARTAS DEVUELTAS:");
        System.out.println("Quedan " + mazo.tamano() + " cartas en el mazo");
        System.out.println("Las cartas devueltas se agregaron al final: " + cartasDevueltas + "\n");
        // buscando que jugador tiene una carta en particular
        String cartaBuscada = "AS de CORAZONES";
        System.out.println("\nBUSCANDO CARTA \"" + cartaBuscada + "\":");
        buscarCartaEnJugadores(cartaBuscada, jugador1, jugador2, jugador3);
    }

    private static void buscarCartaEnJugadores(String representacionCarta, Jugador... jugadores){
        boolean encontrada = false;
        for(Jugador jugador : jugadores){
            for(Carta carta : jugador.getMano()){
                if(carta.toString().equalsIgnoreCase(representacionCarta)){
                    System.out.println("La carta " + representacionCarta + " esta en posesion de: " + jugador.nombre);
                    encontrada = true;
                    break;
                }
            }
        }
        if(!encontrada){
            System.out.println("La carta " + representacionCarta + " esta en el mazo o no fue repartida.");
        }
    }
}
