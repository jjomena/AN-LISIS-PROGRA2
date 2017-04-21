/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import static clases.pruebas.menorFilas;
import static clases.pruebas.pocasPermutaciones;
import static clases.pruebas.solucion;

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
}
