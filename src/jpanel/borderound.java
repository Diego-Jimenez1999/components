/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpanel;

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
 * @author Diego Alexander Gaviria Jimenez
 */
public class borderound  extends AbstractBorder{
      
    
    private float arcw=30;
    private float arch=30;
    private final RenderingHints antialisasing = new  RenderingHints( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
    
    public borderound(float arch, float arcw) {
        this.arch = arch;
        this.arcw = arcw;
    }

    public borderound() {

    }
    
    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {

        Graphics2D g2d = (Graphics2D) g;

        Color oldColor = c.getParent().getBackground(); //pone el borde trasparente
        g2d.setColor(oldColor);
        
        
        
        Shape outer;
        Shape inner;

        int offs = 1;
        int size = offs + offs;

        float arc = .2f * offs;
        outer = new RoundRectangle2D.Float(0, 0, width, height-1,arcw,arch);//crea lo redondo del borde
        inner = new RoundRectangle2D.Float(0, 0, width, height, 0, 0);//limite del borde
        
   

        Path2D path = new Path2D.Float(Path2D.WIND_EVEN_ODD);
        g2d.addRenderingHints(antialisasing);
        path.append(outer, false);
        path.append(inner, false);
        g2d.fill(path);
        g2d.setColor(oldColor);

    }
    
    public float getArch() {
        return arch;
    }

    public float getArcw() {
        return arcw;
    }

    public void setArch(float arch) {
        this.arch = arch;
    }

    public void setArcw(float arcw) {
        this.arcw = arcw;
    }

   
     
    
   
}
