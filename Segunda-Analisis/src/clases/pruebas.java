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
    
    public static void imprimirArrayList(ArrayList<int[]>resultado){
        for(int i=0;i<resultado.size();i++){
            imprimir(resultado.get(i));
        }
    }
    
    
    public static void numerosSumados1(int[]result,int numero,ArrayList<int[]>resultado,int k){
        Random  rnd = new Random();
        //imprimir(result);
        //System.out.println("k1 "+ k);
        if(suma(result)==numero && ceros(result)==false){
            int[] resultAux = (int[])(result.clone());
            if(resultado.contains(resultAux)==true){
                System.out.println("Elemento repetido");
            }else{
                resultado.add(resultAux);
                //return numerosSumados1(result,numero,resultado,k++);
            }
        }
        else{
            if(k <= result.length){
                k++;
                int i = (int)(rnd.nextDouble()*result.length+0);
                //System.out.println("i :"+i);
                for(int j=1;j<10;j++){
                    if(existeElemento(result,j)==false && j < numero-1){
                        result[i] = j;
                        //System.out.println("k "+k);
                        numerosSumados1(result,numero,resultado,k);
                    }
                }
            }   
        }
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
        }
        return null;
    }
    
    
    public static boolean filaDer(Matriz m,int numero,int fila,int columna){
        for(int i=columna;i<m.getTamano();i++){
            Celda celda = m.getCelda()[fila][i];
            System.out.println(celda.getValor());
            if("t1".equals(celda.getTipo()) || "t3".equals(celda.getTipo())){
                return false;
            }else{
                if(celda.getValor()==numero){
                return true;
                }
            }
        }
        return false;
    }
    
    public static boolean filaIzq(Matriz m,int numero,int fila,int columna){
        for(int i=columna;i>0;i--){
            Celda celda = m.getCelda()[fila][i];
            if("t1".equals(celda.getTipo()) || "t3".equals(celda.getTipo())){
                return false;
            }else{
                if(celda.getValor()==numero){
                return true;
                }
            }
        }
        return false;
    }
    
    public static boolean columnaAba(Matriz m,int numero,int fila,int columna){
        for(int i=fila;i<m.getTamano();i++){
            Celda celda = m.getCelda()[i][columna];
            if("t1".equals(celda.getTipo()) || "t3".equals(celda.getTipo())){
                return false;
            }else{
                if(celda.getValor()==numero){
                return true;
                }
            }
        }
        return false;
    }
    
    public static boolean columnaArr(Matriz m,int numero,int fila,int columna){
        for(int i=fila;i>0;i--){
            Celda celda = m.getCelda()[i][columna];
            if("t1".equals(celda.getTipo()) || "t3".equals(celda.getTipo())){
                return false;
            }else{
                if(celda.getValor()==numero){
                return true;
                }
            }
        }
        return false;
    }
    
    public static void backNum(int[]result,int numero,ArrayList<int[]>resultado,int k){
        int[]resultAux = (int[])(result.clone());
        if(suma(resultAux)==numero && ceros(resultAux)!=true){
            resultado.add(resultAux);
        }else{
            if(k<result.length){
                int k1 = k+1;
                for(int i=1;i<=9;i++){
                    if(existeElemento(resultAux,i)!=true && i<numero){
                        resultAux[k]=i;
                        backNum(resultAux,numero,resultado,k1);
                    }
                }
            }
        }
    }
    
    public static Matriz backResolver(Matriz m,int tamano,int colocadas){
        m.crearMatriz(tamano);
        if(colocadas==m.getTamano()){
            return m;
        }else{
            
        }
        return m;
    }
    
    public static Matriz rellenarPared(Matriz m){
        
        
        return m;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
//        pruebas prue  = new pruebas();
        int per = 1; int per1 = 1;
        int numero = 4;
        int casillas = 2;
        int result[] = new int[casillas];
        ArrayList<int[]> resultado = new ArrayList<int[]>();
        if(per ==1){
            backNum(result,numero,resultado,0);
            imprimirArrayList(resultado);
            System.out.println(resultado.size());
        }
        if(per1 == 1){
            Matriz m = new Matriz();
            m.crearMatriz(5);
            m.getCelda()[3][3].setValor(2);
            m.imprimirMatriz();
            if(columnaAba(m,2,0,3)==true){
                System.out.println("repetido");
            }
        }
        
//          Matriz m = new Matriz();
//          backCrear(m,5,0);
//          m.crearMatriz(14);
//          m.getCelda()[3][3].setValor(-1);
//          m.getCelda()[4][4].setValor(-1);
//          m.getCelda()[5][3].setValor(-1);
//          m.getCelda()[6][3].setValor(-1);
//          m.getCelda()[7][3].setValor(-1);
//          m.getCelda()[8][3].setValor(-1);
//          m.getCelda()[9][4].setValor(-1);
//          m.getCelda()[6][1].setValor(-1);
//          m.getCelda()[6][2].setValor(-1);
//          m.getCelda()[7][1].setValor(-1);
//          m.getCelda()[7][2].setValor(-1);
//          m.getCelda()[10][3].setValor(-1);
//          m.getCelda()[12][1].setValor(-1);
//          m.getCelda()[8][5].setValor(-1);
//          m.getCelda()[1][6].setValor(-1);
//          m.getCelda()[2][6].setValor(-1);
//          m.getCelda()[7][6].setValor(-1);
//          m.getCelda()[6][7].setValor(-1);
//          m.getCelda()[7][7].setValor(-1);
//          m.getCelda()[8][8].setValor(-1);
//          m.getCelda()[9][9].setValor(-1);
//          m.getCelda()[10][10].setValor(-1);
//          m.getCelda()[11][7].setValor(-1);
//          m.getCelda()[12][7].setValor(-1);
//          m.getCelda()[5][8].setValor(-1);
//          m.getCelda()[4][9].setValor(-1);
//          m.getCelda()[3][10].setValor(-1);
//          m.getCelda()[6][11].setValor(-1);
//          m.getCelda()[7][11].setValor(-1);
//          m.getCelda()[6][12].setValor(-1);
//          m.getCelda()[6][12].setValor(-1);
//          
//          //System.out.println(m.getTamano());
//          m.imprimirMatriz();
        
    }    
}
