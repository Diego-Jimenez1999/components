
package components;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JComponent;

/**
 * @author Diego Alexander Gaviria Jimenez
 */
public class swiitch extends JComponent implements MouseListener{

    /**
     * Captura el estado del interruptor
     */
    private boolean OnOff = false;
    
    /**
     * Margen entre el borde del componente y el interruptor
     */
    private final int MARGIN = 5;
    
    /**
     * Margen entre el boton circular y el interrutor
     */
    private  int BORDER = 4;

   
    /**
     * Colo de fondo del interruptor NO del componente
     */
    private Color backgroundColor;
    
    /**
     * Color del boton circular del interruptor
     */
    private Color buttonColor;
    
    /**
     * Color del interrupor cuando esta desabilitado
     */
    private final Color DISABLED_COMPONENT_COLOR = new Color(131,131,131);
    
    /**
     * Constructor de clase
     */
    public swiitch(){
        super();
        swiitch.this.setSize(new Dimension(60, 30));
        swiitch.this.setPreferredSize(new Dimension(60, 30));
        swiitch.this.setMinimumSize(new Dimension(60, 30));
        swiitch.this.setVisible(true);
        swiitch.this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        swiitch.this.addMouseListener(swiitch.this);  
        //colores iniciales
        swiitch.this.setBackgroundColor(new Color(0, 156, 132));
        swiitch.this.setButtonColor(new Color(255,255,255));
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (isOpaque()) {//Pinta el fondo del componente
            g2.setColor(getBackground());
            g2.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
        }

        if(isEnabled()){//componente desabilitado
            g2.setColor(( (OnOff) ? getBackgroundColor():new Color(216,217,219) ) );
            g2.fill(new RoundRectangle2D.Double((float) MARGIN, (float) MARGIN, 
                (float) getWidth() - MARGIN * 2, (float) getHeight() - MARGIN * 2,
                getHeight() - MARGIN * 2, getHeight() - MARGIN * 2));
        }else{//componente habilitado
            g2.setColor(DISABLED_COMPONENT_COLOR );    
            g2.draw(new RoundRectangle2D.Double((float) MARGIN, (float) MARGIN, 
                (float) getWidth() - MARGIN * 2, (float) getHeight() - MARGIN * 2,
                getHeight() - MARGIN * 2, getHeight() - MARGIN * 2));
        }
        
        g2.setColor((isEnabled()) ? getButtonColor() : DISABLED_COMPONENT_COLOR);
        //boton circular        
       /* if (OnOff) {//ON a la izquierda           
            g2.fillOval(MARGIN + BORDER / 2, MARGIN + BORDER / 2, 
                    getHeight() - MARGIN * 2 - BORDER, getHeight() - MARGIN * 2 - BORDER);
        } else {//OFF a la derecha
            g2.fillOval(getWidth() - getHeight() + MARGIN + BORDER / 2, MARGIN + BORDER / 2,
                    getHeight() - MARGIN * 2 - BORDER, getHeight() - MARGIN * 2 - BORDER);
        }*/
       
       if (OnOff) {//ON a la izquierda      
               g2.fillOval(getWidth() - getHeight() + MARGIN + BORDER / 2, MARGIN + BORDER / 2,
                    getHeight() - MARGIN * 2 - BORDER, getHeight() - MARGIN * 2 - BORDER);
           
        } else {//OFF a la derecha
             g2.fillOval(MARGIN + BORDER / 2, MARGIN + BORDER / 2, 
                    getHeight() - MARGIN * 2 - BORDER, getHeight() - MARGIN * 2 - BORDER);
           
        }
    }

    /**
     * retorna el estado del interruptor
     * 
     * @return boolean True: ON False: OFF
     */
    public boolean isOnOff() {
        return OnOff;
    }
     
   
    public void setOnOff(boolean OnOff) {
        this.OnOff = OnOff;        
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }
    
    
    
    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Color getButtonColor() {
        return buttonColor;
    }

    public void setButtonColor(Color buttonColor) {
        this.buttonColor = buttonColor;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (isEnabled()) {
            OnOff = !OnOff;
            repaint();
        }
    }
    
    public int getBORDER() {
        return BORDER;
    }

    public void setBORDER(int BORDER) {
        this.BORDER = BORDER;
    }
    
    
    @Override
    public void mousePressed(MouseEvent e) { /*...*/ }

    @Override
    public void mouseReleased(MouseEvent e) { /*...*/ }

    @Override
    public void mouseEntered(MouseEvent e) { /*...*/ }

    @Override
    public void mouseExited(MouseEvent e) { /*...*/ }
    
}//Switch:end
