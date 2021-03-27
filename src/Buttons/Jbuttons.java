/*
 * se creea un boton que sus bordes rean redondos 
 * 
 */
package Buttons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.ImageIcon;
/**
 *
 * @author Diego Alexander Gaviria Jimenez
 */
public final class Jbuttons extends JButton{
    
    String nombre = ""; 
    String url = "";
    ImageIcon imagen = null; 
    private final Dimension dm = new Dimension(100,30); //tamaño del boton
    private final BorderLineRound borde = new BorderLineRound((Color.lightGray.darker()),true);
    
    
       
    
    public Jbuttons(){
        setText(nombre);
        
        
         this.setIcon(imagen);
        setBorder(borde);//pone borde
        setPreferredSize(dm);
        setSize(dm);
        
        setOpaque(true);
        
        setFont(new Font("Tahoma",Font.BOLD,12));
      
        setForeground(Color.BLACK);
        
        
    }
    
    
   
   
    
} 
 

     
      
 
 
 

 /*javax.swing.ImageIcon  imagen = new javax.swing.ImageIcon(getClass().getResource("/imagenes/menu.png"));

 javax.swing.Icon icono = new javax.swing.ImageIcon(imagen.getImage().getScaledInstance(this.getWidth(), this.getHeight(),java.awt.Image.SCALE_DEFAULT));
     this.setIcon(icono);
     this.updateUI(); */
    

