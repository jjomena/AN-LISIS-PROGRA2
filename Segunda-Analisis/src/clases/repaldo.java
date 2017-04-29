/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import static clases.pruebas.backNum;
import static clases.pruebas.backResolver;
import static clases.pruebas.cantidadLista;
import static clases.pruebas.correctoVector;
import static clases.pruebas.menorFilas;
import static clases.pruebas.pocasPermutaciones;
import static clases.pruebas.solucion;
import java.util.ArrayList;

/**
 *
 * @author mailon2
 */
public class repaldo {
    public static Matriz backResolver(Matriz m,int colocadas){
        if(colocadas==m.getTamano()){
            return m;
        }else{
            int[]menor = menorFilas(m);
            if(menor[0]==2){
                return pocasPermutaciones(m,menor[1],menor[2],menor[0]);
            }
            else if(menor[0]==3){
                //System.out.println(menor[1]+" " + menor[2]);
                return pocasPermutaciones(m,menor[1],menor[2],menor[0]);
            }
            else if(menor[0]==4){
                System.out.println("d");
                return pocasPermutaciones(m,menor[1],menor[2],menor[0]);
            }
        }
        if(solucion(m)==false){
            m.imprimirMatriz();
        }
        return m;
    }
    
    
    public static Matriz pocasPermutaciones1(Matriz m,int fila,int columna,int espacios){
        int result[] = new int[espacios];
        ArrayList<int[]> resultado = new ArrayList<int[]>();
        int numero = m.getCelda()[fila][columna-1].getDerecha();
        //System.out.println(numero+ " "+fila+" "+columna);
        backNum(result,numero,resultado,0);
        for(int i=0;i<resultado.size();i++){
            int [] permutacion = resultado.get(i);
            if(correctoVector(m,permutacion,fila,columna)!=true){
                for(int j=0;j<espacios;j++){
                //System.out.println(permutacion[j]);
                    m.getCelda()[fila][columna+j].setValor(permutacion[j]);
                    m.getCelda()[fila][columna+j].setTipo("t4");
                }
                int res = cantidadLista(m);
                //m.imprimirMatriz();
                //System.out.println(res);
                System.out.println("-------------------------------");
                backResolver(m,res);
            }
            
        }
        return m;
    }
    
    
    public static int[]menorFilas(Matriz m){
        int []result = new int[3];
        for(int i=0;i<m.getTamano();i++){
            int contador = 0;
            int fila = i;
            for(int j=0;j<m.getTamano();j++){
                if("t2".equals(m.getCelda()[i][j].getTipo())){
                    contador++;
                }else{
                    if(contador!=0){
                        if(result[0]>contador  || result[0]==0){
                            result[0]=contador;
                            result[1]=fila;
                            result[2]=j-contador;
                            contador= 0;
                        }else{
                            contador =0;
                        }
                    }
                }
            }
        }       
        return result;
    }
}
