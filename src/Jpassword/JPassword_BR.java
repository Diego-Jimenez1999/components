
package Jpassword;

import javax.swing.JPasswordField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

import javax.swing.JCheckBox;
import static javax.swing.SwingConstants.CENTER;

/**
 *
 * @author Diego Alexander Gaviria Jimenez
 */
public class JPassword_BR extends JPasswordField{
    
    private final Dimension dm = new Dimension(250,30);
    private final JCheckBox chek = new JCheckBox();
    private final BorderLineRound borde = new BorderLineRound((Color.lightGray.darker()),true);
    


   
    public JPassword_BR(){
        
        setOpaque(true);
        setBorder(borde);
        setSize(dm);
        setPreferredSize(dm);
        setHorizontalAlignment(CENTER);//lo pone en el centro
        setFont(new Font("Century Gothic",0,12));
        setEchoChar('•');
       
        addFocusListener(new FocusListener(){
            
            @Override
            public void focusGained(FocusEvent e) {
                txtFocusGaided(e); 
            }

            @Override
            public void focusLost(FocusEvent e) {
                txtFocuslost(e);
                setEchoChar('•');
                chek.setIcon(new ImageIcon(getClass().getResource("/Jpassword/Ojo_Desactivado.png")));
                chek.setSelected(false);    
                
            }
            
        });
        
        setLayout(new BorderLayout());
        add(chek, BorderLayout.EAST);
        chek.setIcon(new ImageIcon(getClass().getResource("/Jpassword/Ojo_Desactivado.png")));
        chek.setFocusable(false);
        
        chek.addMouseListener(new MouseAdapter(){ 
        
            @Override
            public void mouseEntered(MouseEvent e){
            
                if(chek.isSelected()){
                   chek.setIcon(new ImageIcon(getClass().getResource("/Jpassword/ojo_Activado.png")));    
                }else{
                   chek.setIcon(new ImageIcon(getClass().getResource("/Jpassword/ojo_Activado.png")));
                } 
                chek.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                
                if(chek.isSelected()){
                    chek.setIcon(new ImageIcon(getClass().getResource("/Jpassword/ojo_Activado.png")));    
                }else{
                   chek.setIcon(new ImageIcon(getClass().getResource("/Jpassword/Ojo_Desactivado.png")));
                   
                } 
                chek.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            
            } 
        });
        
        chek.addActionListener((ActionEvent e) ->{
            if(chek.isSelected()){
                
                chek.setIcon(new ImageIcon(getClass().getResource("/Jpassword/ojo_Activado.png")));    
            }else{
                chek.setIcon(new ImageIcon(getClass().getResource("/Jpassword/ojo_Activado.png")));
            }
            if(chek.isSelected()){
                setEchoChar((char)0);
                requestFocus();
            }else{
             setEchoChar('•');
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
