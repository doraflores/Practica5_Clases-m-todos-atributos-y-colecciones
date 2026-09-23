package org.example;

public class Carta {
    private int valor;
    private Figura tipo;

    public Carta(int valor, Figura tipo){
        this.valor = valor;
        this.tipo = tipo;
    }

    public int getValor(){
        return valor;
    }

    public Figura getTipo(){
        return tipo;
    }

    public String toString(){
        return valor + " de " + tipo;
    }
}
