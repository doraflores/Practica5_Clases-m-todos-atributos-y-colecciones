package org.example;

import java.util.ArrayList;

public class Jugador {
    public String nombre;
    private ArrayList<Carta> mano;

    public Jugador(String nombre){
        this.nombre = nombre;
        this.mano = new ArrayList<>();
    }

    // asignar un conjunto de cartas a la mano del jugador
    public void recibirCartas(ArrayList<Carta> nuevasCartas){
        mano.addAll(nuevasCartas);
    }

    // asignar una carta
    public void recibirCarta(Carta carta){
        this.mano.add(carta);
    }

    // deshacerse de cartas
    public ArrayList<Carta> devolverCartas(int cantidad){
        ArrayList<Carta> cartasDevueltas = new ArrayList<>();

        for (int i = 0; i < cantidad && !mano.isEmpty(); i++) {
            cartasDevueltas.add(mano.remove(0));
        }
        return cartasDevueltas;
    }

    // devolcer una cadena con la informacion del jugador
    public String obtenerInformacion(){
        StringBuilder sb = new StringBuilder();
        sb.append(nombre).append(" tiene: ");
        if(mano.isEmpty()){
            sb.append("[Sin cartas]");
        }else{
            for (Carta carta : mano){
                sb.append("[").append(carta.toString()).append("] ");
            }
        }
        return sb.toString().trim();
    }
    //metodo para consultar la mano
    public ArrayList<Carta> getMano(){
        return mano;
    }
}
