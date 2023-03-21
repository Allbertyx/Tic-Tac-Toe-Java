package tica_tac_toe;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Imagen extends JPanel{
    private Image fondo=null;
   
 
    public Imagen() {
        this.setSize(85, 100); //se selecciona el tamaño del panel
    }
    public Imagen(int alto, int largo) {
        this.setSize(largo, alto); //se selecciona el tamaño del panel
    }
 
    @Override
    public void paint(Graphics grafico){
        Dimension height = getSize();
        grafico.drawImage(fondo, 0, 0, height.width, height.height, null);
        setOpaque(false);
        super.paintComponent(grafico);
    }
    
    public void setImage(String image){
        if (image!=null) {
            fondo=new ImageIcon(getClass().getResource(image)).getImage();
        }
    }
    
}
