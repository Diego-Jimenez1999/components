
package jpanel;


import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author Diego Alexander Gaviria Jimenez
 */
public class Jpanel extends JPanel{
    
    Dimension d = new Dimension(100, 100);
   
    private int arcw=30;
    private int arch=30;

  
    public  borderound borde =new borderound();
    
    public Jpanel(){
        super();
        setSize(d);
        setPreferredSize(d);
        setBackground(Color.WHITE);
        setBorder(borde);          
    }
    
  
    
    public int getArcw() {
        return arcw;
    }

    

    public int getArch() {
        return arch;
    }

    public void setArcw(int arcw) {
        this.arcw = arcw;

    }
    
    public void setArch(int arch) {
         this.arch = arch;
    } 
   
    
    
}
