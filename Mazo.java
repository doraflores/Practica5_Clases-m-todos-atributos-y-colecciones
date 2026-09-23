package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class Mazo {
    private ArrayList<Carta> mazo;
    public Mazo(){
        this.mazo = new ArrayList<>();

    }

    // restablecer el mazo a su configuración inicial con 52 cartas
    public void inicializarMazo(){
        mazo.clear();
        for(Figura tipo : Figura.values()){
            for (int valor = 0; valor <= 13; valor++) {
                mazo.add(new Carta(valor, tipo));
            }
        }
    }

    // barajear el mazo
    public void barajear(){
        Collections.shuffle(mazo);
    }

    // repartir cartas tomando en cuenta el numero de cartas por jugador y
    // la existencia de diferentes tipos de cartas.
    public ArrayList<Carta> repartirCartas(int cantidad){
        ArrayList<Carta> mano = new ArrayList<>();
        ArrayList<Carta> cartasRepartidas = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            if(!mazo.isEmpty()){
                cartasRepartidas.add(mazo.remove(0));
            }
        }
        return cartasRepartidas;
    }

    // gestionar pila de cartas no repartidas
    public void agregarCarta(Carta carta){
        mazo.add(carta);
    }

    public void agregarCartas(ArrayList<Carta> nuevasCartas){
        mazo.addAll(nuevasCartas);
    }

    // sacar cartas de la pila
    public Carta sacarCarta(int numero){
        if (numero >= 0 && numero < mazo.size()) {
            return mazo.remove(numero);
        }
        return null;
    }



}
