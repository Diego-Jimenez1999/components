package jpanel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

/**
 *
 * @author Diego Alexander Gaviria Jimenez
 */
public class Jpanel extends JPanel {
 Dimension d = new Dimension(100, 100);
    float arch=30;      
    float arcw=30;  
    
    private final borderound borde = new borderound();
     
    

    public Jpanel() {
        super();
        setSize(d);
        setPreferredSize(d);
        setBackground(Color.WHITE);
        setBorder(borde);
    }
    
  
    

    public float getArch() {
        return arch;
    }

    public float getArcw() {
        return arcw;
    }

   

    public void setArch(float arch) {
        this.arch = arch;
        borde.setArch(arch);
    }

    

    public void setArcw(float arcw) {
        this.arcw = arcw;
        borde.setArcw(arcw);
    }
}
