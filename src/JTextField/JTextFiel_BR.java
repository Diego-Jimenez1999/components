package JTextField;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import javax.swing.JTextField;
import java.awt.event.FocusListener;

/**
 * @author Diego Alexander Gaviria Jimenez 
 */
public class JTextFiel_BR extends JTextField{
    
    private final Dimension dm = new Dimension(250,28);
    private final BorderLineRound borde = new BorderLineRound((Color.lightGray.darker()),true);
    
    public JTextFiel_BR(){
        setOpaque(true);
        setBorder(borde);
        setSize(dm);
        setPreferredSize(dm);
        setHorizontalAlignment(CENTER);//lo pone en el centro
        setFont(new Font("Century Gothic",0,12));
        
        addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e) {
                txtFocusGaided(e);
            }

            @Override
            public void focusLost(FocusEvent e) {
                txtFocuslost(e);
            }
        });
    }
    
    public void txtFocusGaided(FocusEvent evy){
        setBorder(new BorderLineRound(Color.lightGray,true));  
    }
    
    public void txtFocuslost(FocusEvent evy){
        setBorder(borde);
    }
    
}