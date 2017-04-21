/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author mailon2
 */
public class Matriz {
    private Celda[][] matriz;
    private int tablero;
    
    public Matriz(){};

    public Celda[][] getCelda() {
        return matriz;
    }

    public void setMatriz(Celda[][] matriz) {
        this.matriz = matriz;
    }
    
    
    public void crearMatriz(int size){
        matriz = new Celda[size][size];
        tablero = 0;
        Random  rnd = new Random();
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz.length;j++){
            Celda celda;
            if(i==0 || i==matriz.length-1 || j==0 || j==matriz.length-1){
                celda = new Celda(-1);
                matriz[i][j] = celda;    
            }else{
                celda = new Celda(0);
                matriz[i][j] = celda;    
            }      
            }
            
        }
    }
    public void imprimirMatriz(){
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz.length;j++){
                if("t1".equals(matriz[i][j].getTipo())){
                    System.out.print("("+matriz[i][j].getValor()+",-1"+") ");
                }else if("t2".equals(matriz[i][j].getTipo())||"t4".equals(matriz[i][j].getTipo())){
                    //System.out.print(matriz[i][j].getValor());
                    System.out.print("("+matriz[i][j].getValor()+",0"+") ");
                }else{
                    System.out.print("("+matriz[i][j].getDerecha()+","+matriz[i][j].getAbajo()+") ");
                }
            }
            System.out.print("\n");
        }
    }
    public static void print(Object imprimir){
            System.out.print(imprimir);
    }

    public int getTamano(){
        return matriz.length;
    }
    
    public int getDimensiones(){
        return matriz.length*matriz.length;
    }
    
    public void tablero(){
        int contador = 0;
        for(int i=1;i<matriz.length;i++){
            for(int j=0;j<matriz.length;j++){
                if(matriz[i][j].getValor() ==-1){
                    
                }
            }
        }
    }
    
    @Override
    public String toString() {
        return "Matriz{" + "matriz=" + matriz + '}';
    }
    
}
