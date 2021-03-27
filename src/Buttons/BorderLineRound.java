/*
 * tiene la funcion de poner los bordes del jbutton  redondeados
 */
package Buttons;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Path2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.border.AbstractBorder;


/**
 *
 *@author Diego Alexander Gaviria Jimenez 
 */
public class BorderLineRound extends  AbstractBorder{
    
    Color lineColor = null;
    boolean roundedCorners = false;
    RenderingHints antiliasing = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        
    public BorderLineRound(Color linecolor, boolean roundedCorners){
        this.lineColor = linecolor;
        this.roundedCorners = roundedCorners;
    
    }
    
    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        
        Graphics2D g2d = (Graphics2D) g; //pinta la forma del componente
           
        Shape outer; //modica el exterior del componente
        Shape inner; //modifica el interior 

        //lineas
        if (roundedCorners) {
            //modifica el compontente segun du tamaño
            int offs = 1;                
            int size = offs + offs;
            float arc = .2f * offs;
            
            //pone un marco de agua en el exterior del componente
            g2d.setColor(lineColor);
            //modica el exterior del componente
            outer = new RoundRectangle2D.Float(x + 3, y + 3, width - 5, height - 5, offs * 30, offs * height);
            //modifica el interior
            inner = new RoundRectangle2D.Float(x + offs - 2, y + offs - 2, width - size + 4, height - size + 4, arc, arc);
          //    outer = new RoundRectangle2D.Float(x + 1, y + 1, width - 3, height - 3, offs * 30, offs * height); 
            //  inner = new RoundRectangle2D.Float(x + offs - 1, y + offs - 1, width - size + -3, height - size + 3, arc, arc);
              
            Path2D path = new Path2D.Float(Path2D.WIND_EVEN_ODD);
                g2d.addRenderingHints(antiliasing);
                path.append(outer, false);
                path.append(inner, false);
                g2d.fill(path);
            }
            //camuflar lineas 
            Color oldColor = c.getParent().getBackground();
            g2d.setColor(oldColor);
            
             int offs = 1;
                int size = offs + offs;
                float arc = .2f * offs;
                outer = new RoundRectangle2D.Float(x , y , width , height , offs * 30, offs * height);
                inner = new RoundRectangle2D.Float(x + offs - 2, y + offs - 2, width - size + 4, height - size + 4, arc, arc);
                //g2d.setColor(lineColor);
                Path2D path = new Path2D.Float(Path2D.WIND_EVEN_ODD);
                g2d.addRenderingHints(antiliasing);
                path.append(outer, false);
                path.append(inner, false);
                g2d.fill(path);
        
    } 
    
}
