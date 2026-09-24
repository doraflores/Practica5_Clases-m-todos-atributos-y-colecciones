package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class Mazo {
    private ArrayList<Carta> mazo;
    public Mazo(){
        this.mazo = new ArrayList<>();
        inicializarMazo();
    }

    // restablecer el mazo a su configuración inicial con 52 cartas
    public void inicializarMazo(){
        mazo.clear();
        for(Figura tipo : Figura.values()){
            for (int valor = 1; valor <= 13; valor++) {
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
        for (int i = 0; i < cantidad && !mazo.isEmpty(); i++) {
            mano.add(mazo.remove(0));
        }
        return mano;
    }

    // gestionar pila de cartas no repartidas
    public void agregarCarta(Carta carta){
        mazo.add(carta);
    }

    public void agregarCartas(ArrayList<Carta> nuevasCartas){
        mazo.addAll(nuevasCartas);
    }

    // sacar carta de la pila
    public Carta sacarCarta(){
        if (!mazo.isEmpty()) {
            return mazo.remove(0);
        }
        return null;
    }

    // devulve la cantidad de cartas
    public int tamano(){
        return mazo.size();
    }

    // mostrar las primeras "n" cantidad de cartas del mazo
    public void mostrarPrimerasCartas(int n){
        int limite = Math.min(n, mazo.size());
        for (int i = 0; i < limite; i++) {
            System.out.println(mazo.get(i) + " ");
        }
        System.out.println();
    }
}
