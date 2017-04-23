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
    
    public static int[]menorFilas(Matriz m){
        int []result = new int[3];
        for(int i=0;i<m.getTamano();i++){
            int contador = 0;
            int fila = i;
            for(int j=0;j<m.getTamano();j++){
                if("t2".equals(m.getCelda()[i][j].getTipo())){
                    contador++;
                }else{
                    if(contador!=0 && contador!=1){
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
    
    public static int cantidadLista(Matriz m){
        int contador = 0;
        for(int i=0;i<m.getTamano();i++){
            for(int j=0;j<m.getTamano();j++){
                if(!"t2".equals(m.getCelda()[i][j].getTipo())){
                    contador++;
                }
            }
        }
        
        return contador;
    }
    
    public static boolean correctoVector(Matriz m,int[] permutacion,int fila,int columna){
        for(int i=0;i<permutacion.length;i++){
            if(columnaAba(m,permutacion[i],fila,columna+i)==true || columnaArr(m,permutacion[i],fila,columna+i) == true
                    || filaDer(m,permutacion[i],fila,columna+i) == true || filaIzq(m,permutacion[i],fila,columna+i)==true){
                return true;
        }
        }
        return false;
    }
    
    public static Celda[][] clonarM(Matriz m){
        Celda[][] celda = new Celda[m.getTamano()][m.getTamano()];
        for(int i=0;i<m.getTamano();i++){
            for(int j=0;j<m.getTamano();j++){
                Celda aux = new Celda();
                aux.setAbajo(m.getCelda()[i][j].getAbajo());
                aux.setArriba(m.getCelda()[i][j].getArriba());
                aux.setDerecha(m.getCelda()[i][j].getDerecha());
                aux.setIzquierda(m.getCelda()[i][j].getIzquierda());
                aux.setTipo(m.getCelda()[i][j].getTipo());
                aux.setValor(m.getCelda()[i][j].getValor());
                celda[i][j] = aux;
            }
        }
        return celda;
    }
    
    public static Matriz pocasPermutaciones(Matriz matriz,int fila,int columna,int espacios){
        int result[] = new int[espacios];
        Matriz m = new Matriz();
        m.setMatriz((Celda[][])matriz.getMatriz().clone());
        Celda[][] celd = new Celda[m.getTamano()][m.getTamano()];
        celd = clonarM(m);
        Matriz m1 = new Matriz();
        m1.setMatriz(celd);
        ArrayList<int[]> resultado = new ArrayList<int[]>();
        int numero = m.getCelda()[fila][columna-1].getDerecha();
        backNum(result,numero,resultado,0);
        for(int i=0;i<resultado.size();i++){
            int [] permutacion = resultado.get(i);
            if(correctoVector(m1,permutacion,fila,columna)!=true){
                for(int j=0;j<espacios;j++){
                    m.getCelda()[fila][columna+j].setValor(permutacion[j]);
                    m.getCelda()[fila][columna+j].setTipo("t4");
                }
                Matriz m2 = new Matriz();
                Celda[][] c1 = clonarM(m);
                m2.setMatriz(c1);
                int res = cantidadLista(m2)+espacios;
                backResolver(m2,res);
            }else{
                //m.imprimirMatriz();
                //imprimir(permutacion);
            }
        }
        return m;
    }
    
    public static boolean solucion(Matriz m){
        for(int i=0;i<m.getTamano();i++){
            for(int j=0;j<m.getTamano();j++){
                Celda celda = m.getCelda()[i][j];
                if("t4".equals(celda.getTipo())){
                    if(columnaAba(m,celda.getValor(),i+1,j)==true || columnaArr(m,celda.getValor(),i-1,j) == true
                    || filaDer(m,celda.getValor(),i,j+1) == true || filaIzq(m,celda.getValor(),i,j-1)==true){
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    public static boolean evaluarColumna(Matriz m,int fila,int columna){
        int numero = m.getMatriz()[fila][columna].getAbajo();
        int result = 0;
        for(int i=1;i<m.getTamano();i++){
            Celda celda = m.getCelda()[fila+i][columna];
            if("t4".equals(celda.getTipo())){
                result += celda.getValor();
            }else{
                if(result==numero){
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }
    
    public static boolean solucionColumnas(Matriz m){
        for(int i=0;i<m.getTamano();i++){
            for(int j=0;j<m.getTamano();j++){
                Celda celda = m.getCelda()[i][j];
                if("t3".equals(celda.getTipo())){
                    if(celda.getAbajo()!=-1){
                        if(evaluarColumna(m,i,j)!=true){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    
    public static Matriz backResolver(Matriz m,int colocadas){
        //Matriz m = new Matriz();
        //m.setMatriz((Celda[][])matriz.getMatriz().clone());
        Celda[][] celda = clonarM(m);
        //System.out.println(colocadas + " tamaño destino: " +m.getDimensiones());
        int colocada = cantidadLista(m);
        if(colocada >= m.getDimensiones()){
            if(solucion(m)==false && solucionColumnas(m)==true){
                System.out.println("-");
                m.imprimirMatriz();
            }
            return m;
        }else{
            int[]menor = menorFilas(m);
            //m.imprimirMatriz();
            if(menor[0]>1){
                return pocasPermutaciones(m,menor[1],menor[2],menor[0]);
            }else{
                //System.out.println("-----------------------------------------");
               // m.imprimirMatriz();
            }
//            else if(menor[0]==3){
//                //System.out.println(menor[1]+" " + menor[2]);
//                return pocasPermutaciones(m,menor[1],menor[2],menor[0]);
//            }
//            else if(menor[0]==4){
//                return pocasPermutaciones(m,menor[1],menor[2],menor[0]);
//            }
        }
        //System.out.println("-------------------------------");
        //m.imprimirMatriz();
        return m;
    }
    
    
    
    
    public static Matriz rellenarPared(Matriz m){
        
        
        return m;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
//        pruebas prue  = new pruebas();
        int per = 12; int per1 = 12; int per2=12; int per3 =1;
        int numero = 17;
        int casillas = 3;
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
        if(per2==1){
            Matriz m = new Matriz();
            m.crearMatriz(5);
            m.getCelda()[0][0].setTipo("t3");
            m.getCelda()[0][0].setDerecha(6);
            m.getCelda()[1][0].setTipo("t3");
            m.getCelda()[1][0].setDerecha(14);
            m.getCelda()[0][4].setTipo("t3");
            m.getCelda()[1][4].setTipo("t3");
            m.getCelda()[2][3].setTipo("t3");
            m.getCelda()[2][4].setTipo("t3");
            m.getCelda()[3][0].setTipo("t3");
            m.getCelda()[3][3].setTipo("t3");
            m.getCelda()[3][4].setTipo("t3");
            m.getCelda()[4][0].setTipo("t3");
            m.getCelda()[4][0].setTipo("t3");
            m.getCelda()[4][1].setTipo("t3");
            m.getCelda()[4][2].setTipo("t3");
            m.getCelda()[4][3].setTipo("t3");
            m.getCelda()[4][4].setTipo("t3");
            m.getCelda()[3][0].setDerecha(5);
            m.getCelda()[2][0].setTipo("t3");
            m.getCelda()[2][0].setDerecha(9);
            //int[] resultd = menorFilas(m);
            //imprimir(resultd);
            int res = cantidadLista(m);
            backResolver(m,res);
            //System.out.println(res);
            //pocasPermutaciones(m,resultd[1],resultd[2],resultd[0]);
        }
        if(per3==1){
            Matriz m = new Matriz();
            m.crearMatriz(10);
            m.getCelda()[0][0].setTipo("t3");
            m.getCelda()[0][1].setTipo("t3");
            m.getCelda()[0][1].setAbajo(3);
            m.getCelda()[0][2].setTipo("t3");
            m.getCelda()[0][2].setAbajo(6);
            m.getCelda()[0][5].setTipo("t3");
            m.getCelda()[0][5].setAbajo(8);
            m.getCelda()[0][6].setTipo("t3");
            m.getCelda()[0][6].setAbajo(4);
            m.getCelda()[0][7].setTipo("t3");
            m.getCelda()[0][7].setAbajo(10);
            m.getCelda()[1][0].setTipo("t3");
            m.getCelda()[1][0].setDerecha(3); 
            m.getCelda()[1][3].setTipo("t1");
            m.getCelda()[1][4].setTipo("t3");
            m.getCelda()[1][4].setDerecha(6); 
            m.getCelda()[1][4].setAbajo(6);
            m.getCelda()[1][8].setTipo("t3");
            m.getCelda()[2][0].setTipo("t3");
            m.getCelda()[2][0].setDerecha(4);
            m.getCelda()[2][3].setTipo("t3");
            m.getCelda()[2][3].setDerecha(10);
            m.getCelda()[2][3].setAbajo(7);
            m.getCelda()[2][8].setTipo("t3");
            m.getCelda()[2][8].setAbajo(4); 
            m.getCelda()[3][1].setTipo("t3");
            m.getCelda()[3][1].setDerecha(11);
            m.getCelda()[3][6].setTipo("t3");
            m.getCelda()[3][6].setDerecha(4);
            m.getCelda()[3][6].setAbajo(7);            
            m.getCelda()[4][1].setTipo("t3");
            m.getCelda()[4][1].setAbajo(4);
            m.getCelda()[4][2].setTipo("t3");
            m.getCelda()[4][2].setDerecha(3);
            m.getCelda()[4][2].setAbajo(11);
            m.getCelda()[4][5].setTipo("t3");
            m.getCelda()[4][5].setDerecha(7);
            m.getCelda()[4][5].setAbajo(8);
            m.getCelda()[5][0].setTipo("t3");
            m.getCelda()[5][0].setDerecha(7);
            m.getCelda()[5][4].setTipo("t3");
            m.getCelda()[5][4].setDerecha(4);
            m.getCelda()[5][4].setAbajo(6);
            m.getCelda()[5][7].setTipo("t3");
            m.getCelda()[5][7].setAbajo(22);
            m.getCelda()[5][8].setTipo("t1");
            m.getCelda()[6][0].setTipo("t3");
            m.getCelda()[6][0].setDerecha(4);
            m.getCelda()[6][3].setTipo("t3");
            m.getCelda()[6][3].setDerecha(11);
            m.getCelda()[6][3].setAbajo(4);
            m.getCelda()[6][8].setTipo("t3");
            m.getCelda()[6][8].setAbajo(16);
            m.getCelda()[7][1].setTipo("t3");
            m.getCelda()[7][1].setDerecha(13);
            m.getCelda()[7][6].setTipo("t3");
            m.getCelda()[7][6].setDerecha(17);
            m.getCelda()[8][1].setTipo("t3");
            m.getCelda()[8][1].setDerecha(6);
            m.getCelda()[8][5].setTipo("t1");
            m.getCelda()[8][6].setTipo("t3");
            m.getCelda()[8][6].setDerecha(16);
            //int[] resultd = menorFilas(m);
            //imprimir(resultd);
            int res = cantidadLista(m);
            m.imprimirMatriz();
            System.out.println("---------------------------------------");
            backResolver(m,res);
            //System.out.println(res);
            //pocasPermutaciones(m,resultd[1],resultd[2],resultd[0]);
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
