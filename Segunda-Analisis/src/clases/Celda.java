/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author mailon2
 */
public class Celda {
    private String tipo;  //Si es t1 significa que no es una casilla permitida o pared
                          //Si es t2 significa que es casilla jugable
                          //Si es t3 significa que es casilla indice
    private int valor;    
    private int derecha;
    private int abajo;

    public Celda(){
        this.tipo = "t1";
        this.derecha = -1;
        this.abajo = -1;
        this.valor = -1;
    }
    public Celda(int valor){
        this.tipo = "t2";
        this.derecha = -1;
        this.abajo = -1;
        this.valor = valor;
        
    }
    public Celda(int derecha,int abajo) {
        this.tipo = "t3";
        this.derecha = derecha;
        this.abajo = abajo;
        this.valor = -1;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getDerecha() {
        return derecha;
    }

    public void setDerecha(int derecha) {
        this.derecha = derecha;
    }

    public int getAbajo() {
        return abajo;
    }

    public void setAbajo(int abajo) {
        this.abajo = abajo;
    }

    @Override
    public String toString() {
        return "Celda{" + "tipo=" + tipo + ", valor=" + valor + ", derecha=" + derecha + ", abajo=" + abajo + '}';
    }

    
}                  
