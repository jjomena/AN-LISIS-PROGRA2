/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author mailon2
 */
public class GUIMatriz {
    private ArrayList<GUICelda> matriz;
    private int len_x;          //longitud en x del frame donde se pondran
    private int pos_y;      //posicion en y de la fila
    private int tamano;
    JPanel panel;
    
    public GUIMatriz(int tamano,int len_x,int pos_y,JPanel parent,Celda f){
        matriz = new ArrayList<GUICelda>();
        this.panel=parent;
        this.pos_y=pos_y;
        this.tamano=tamano;
        this.len_x=len_x;
        
        int x_posicional=len_x/(tamano+1);      //a partir de donde se pondran las fracciones en la interfaz
        int x_incremento=x_posicional;
        
        int y_posicional=len_x/(tamano+1);
        int y_incremento=y_posicional;
        for(int i=0;i<this.tamano;i++){
            x_posicional=len_x/(tamano+1);
            for(int j=0;j<tamano;j++){
                matriz.add(new GUICelda(parent,x_posicional,y_posicional,i+1));
                x_posicional+=x_incremento-10;
            }
            y_posicional += y_incremento-10;
        }
    }
}
