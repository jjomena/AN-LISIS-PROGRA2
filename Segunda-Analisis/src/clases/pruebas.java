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
public class pruebas {
    private Matriz matriz;
    private ArrayList<int[]> arreglo = new ArrayList();

    public Matriz getMatriz() {
        return matriz;
    }

    public void setMatriz(Matriz matriz) {
        this.matriz = matriz;
    }

    public ArrayList<int[]> getArreglo() {
        return arreglo;
    }

    public void setArreglo(ArrayList<int[]> arreglo) {
        this.arreglo = arreglo;
    }
    
    public static int suma(int[]fila){
        int result = 0;
        for(int i=0;i<fila.length;i++){
            result += fila[i];
        }
        return result;
    }
    public static boolean existeElemento(int[]arreglo,int elem){
        for(int i=0;i<arreglo.length;i++){
            if(arreglo[i]==elem){
                return true;
            }
        }
        return false;
    }
    public static int posicion(int[]arreglo,int elem){
        for(int i=0;i<arreglo.length;i++){
            if(arreglo[i]==elem){
                return i;
            }
        }
        return -1;
    }
    
    public static boolean ceros(int[]arreglo){
        for(int i=0;i<arreglo.length;i++){
            if(arreglo[i]==0){
                return true;
            }
        }
        return false;
    }
    
    public static void imprimir(int[]arreglo){
        String cadena = "";
        for(int i=0;i<arreglo.length;i++){
            cadena += arreglo[i]+" ";
        }
        System.out.println(cadena);
    }
    
    public static int[] numerosSumados(int[]result,int numero,ArrayList<int[]>resultado){
        imprimir(result);
        if(suma(result)==numero){
            imprimir(result);
        }
        else{
            for(int i=0;i<result.length;i++){
                for(int j=1;j<10;j++){
                    System.out.println("valor de j"+j);
                    if(existeElemento(result,j)!=true){
                        result[i]=j;
                        numerosSumados(result,numero,resultado);
                    }
                }
                
            }
            imprimir(result);
        }
        return null;
    }
    public static int[] numerosSumados1(int[]result,int numero,ArrayList<int[]>resultado){
        Random  rnd = new Random();
        //imprimir(result);
        if(suma(result)==numero && ceros(result)==false){
            imprimir(result);
            return result;
        }
        else{
            int i = (int)(rnd.nextDouble()*3+0);
              for(int j=1;j<10;j++){
                 System.out.println(j);
                if(existeElemento(result,j)==false && j < numero-1){
                    result[i] = j;
                    numerosSumados1(result,numero,resultado);
                }
            }
            System.out.println("For");
        }
        return null;
    }
    
    public static int[] numerosSumadosA(int[]result,int numero,ArrayList<int[]>resultado){;
        imprimir(result);
        if(suma(result)==numero && ceros(result)==false){
            imprimir(result);
            return result;
        }
        else{
            for(int i=1;i<result.length;i++){
                for(int j=1;j<10;j++){
                    if(existeElemento(result,j)==false && j < numero-1){
                        imprimir(result);
                        result[i] = j;
                        numerosSumadosA(result,numero,resultado);
                    }
                }
            }
              
            //System.out.println("For");
        }
        return null;
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        pruebas prue  = new pruebas();
        int result[] = new int[3];
        ArrayList<int[]> resultado = new ArrayList<int[]>();
        //numerosSumados(result,10,resultado);
        
        //result = numerosSumados1(result,10,resultado);
        Porque(0);
        if(result!= null){
            //imprimir(result);
        }
        else{
            System.out.println("null");
        }   
    }    
}
