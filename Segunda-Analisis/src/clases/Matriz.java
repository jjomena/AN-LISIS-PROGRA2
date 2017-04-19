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
    
    public Matriz(){};

    public Celda[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(Celda[][] matriz) {
        this.matriz = matriz;
    }
    
    
    public void crearMatriz(int size){
        matriz = new Celda[size][size];
        Random  rnd = new Random();
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz.length;j++){
            Celda celda;
            int prue = (int)(rnd.nextDouble() * 100+1);
            
            if(prue<33){
                celda = new Celda();
            }else if(prue<66){
                celda = new Celda(prue);
            }else{
                celda = new Celda(10,12);
            }
            matriz[i][j] = celda;    
            }
            
        }
    }
    public void imprimirMatriz(){
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz.length;j++){
                if("t1".equals(matriz[i][j].getTipo())){
                    System.out.print("("+matriz[i][j].getValor()+",-1"+") ");
                }else if("t2".equals(matriz[i][j].getTipo())){
                    System.out.print("("+matriz[i][j].getValor()+",00"+") ");
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

    @Override
    public String toString() {
        return "Matriz{" + "matriz=" + matriz + '}';
    }
    
}
