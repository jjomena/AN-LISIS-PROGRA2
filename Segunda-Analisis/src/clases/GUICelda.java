/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.Color;
import java.awt.Label;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author mailon2
 */
public class GUICelda {
    private int rows=1;
    private int columns=2;
    public JTextArea celda;
    int y;
    
    public GUICelda(JPanel panel,int cord_x,int cord_y,int y){
    this.y = y;
    celda = new JTextArea(rows,columns);
    cord_y-=30;
    cord_x-=7;
    celda.setBounds(cord_x, cord_y, 30, 30);
    panel.add(celda);
    panel.repaint();
    panel.revalidate();
    }
    
    public void setValor(int valor){
        celda.setText(Integer.toString(valor));
    }
    
    public JTextArea getCelda(){
        return celda;
    }
    
}
