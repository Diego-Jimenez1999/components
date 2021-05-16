/*
 * se creea un boton que sus bordes rean redondos 
 * 
 */
package Buttons;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;
import javax.swing.ImageIcon;
/**
 *
 * @author Diego Alexander Gaviria Jimenez
 */
public final class jButtonsBr extends JButton{
    
    private final Dimension dm = new Dimension(100, 30); //tamaño del boton
    Color color = new Color(240, 240, 240);
    Color colorborde = new Color(247, 247, 247);
    private  boolean Estado_borde = true;
    
    //inicio del componente
    public jButtonsBr(){
       
          //tamaño del componente
        setPreferredSize(dm);//tamaño del boton
        setSize(dm);//tamaño del boton

        setOpaque(false);
        setFont(new Font("Tahoma",Font.BOLD,12));//tipo de letra
        setContentAreaFilled(false);
        setForeground(Color.BLACK);
        setFocusPainted(false);
        setBorderPainted(false); 
    }
    
    
       @Override

    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Paint oldPaint = g2.getPaint();
        
        //angulos del componete
        RoundRectangle2D.Float r2d = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 40, 40);
        g2.clip(r2d);
        //color del componente
        g2.setPaint(new GradientPaint(0.0f, 0.0f, getColor(),
                0.0f, getHeight(), getColor()));
        g2.fillRect(0, 0, getWidth(), getHeight());

        if (Estado_borde != false) {//activa y desactiva borde
            g2.setStroke(new BasicStroke(2f)); //grosor del borde
            g2.setPaint(new GradientPaint(0.0f, 0.0f, getColorborde(),  //color del borde
                    0.0f, getHeight(), getColorborde()));

            g.drawRoundRect(1, 1, getWidth() - 2,
                    getHeight() - 2, 38, 38);
        }
        
        //vuelve a pintar el componete
        g2.setPaint(oldPaint); 
        super.paintComponent(g);
    }
    
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColorborde() {
        return colorborde;
    }

    public void setColorborde(Color colorborde) {
        this.colorborde = colorborde;
    }

    public boolean isEstado_borde() {
        return Estado_borde;
    }

    public void setEstado_borde(boolean estado_borde) {
        this.Estado_borde = estado_borde;
    }

    
       
    
} 
    

