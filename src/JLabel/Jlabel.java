
package JLabel;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author Diego Alexander Gaviria Jimenez
 */
public class Jlabel extends JLabel{
    
    
    private String nombre = "";
    private ImageIcon icono = null;
    private final BordeRound borde =new BordeRound();
   
    public Jlabel(){
    nombre = "";
    InitComponet();
    }
    
    public Jlabel(String info){
    nombre = info;
    InitComponet();
    }
    
    public Jlabel(ImageIcon info){
    icono = info;
    InitComponet();
    }
    
    private void InitComponet(){
    setText(nombre); //coloca el nombre
    setHorizontalAlignment(CENTER);//lo pone en el centro
    setIcon(icono);//coloca imagen
    setOpaque(true);//coloca trasparente
    setBorder(borde);//pone borde
    setPreferredSize(new Dimension(100,100));
        
    
    }
    
}
