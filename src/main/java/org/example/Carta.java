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
        String nombreValor;
        switch (valor){
            case 1:
                nombreValor = "AS";
                break;
            case 11:
                nombreValor = "JOTA";
                break;
            case 12:
                nombreValor = "REINA";
                break;
            case 13:
                nombreValor = "REY";
                break;
            default:
                nombreValor = String.valueOf(valor);
                break;
        }
        return "[" + nombreValor + " de " + tipo + "]";
    }
}
