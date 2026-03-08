package components;

import borders.BorderLineRound;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

/**
 * JTextField personalizado con borde redondeado
 * y cambio de color cuando recibe foco.
 * 
 * @author Diego Alexander Gaviria
 */
public class JTextFiel_BR extends JTextField {

    private final Dimension dm = new Dimension(250, 28);

    private int radius = 30;

    private final Color colorInicial = Color.LIGHT_GRAY.darker();

    private Color color_G = new Color(109,109,109);

    /**
     * Obtiene el color del borde cuando el campo recibe foco
     * @return 
     */
    public Color getColor_G() {
        return color_G;
    }

    /**
     * Cambia el color del borde cuando el campo recibe foco
     * @param color_G
     */
    public void setColor_G(Color color_G) {
        this.color_G = color_G;
    }

    /**
     * Obtiene el radio del borde
     * @return 
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Cambia el radio del borde
     * @param radius
     */
    public void setRadius(int radius) {
        this.radius = radius;
        actualizarBorde();
        repaint();
    }

    /**
     * Constructor del componente
     */
    public JTextFiel_BR(){

        setOpaque(false); // IMPORTANTE

        setBackground(Color.WHITE);

        setPreferredSize(dm);

        setHorizontalAlignment(CENTER);

        setFont(new Font("Century Gothic", Font.PLAIN, 12));

        setMargin(new Insets(5,12,5,12));

        actualizarBorde();

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

    /**
     * Actualiza el borde
     */
    private void actualizarBorde(){
        setBorder(new BorderLineRound(radius,1,colorInicial,false));
    }

    /**
     * Evento cuando recibe foco
     * @param evy
     */
    public void txtFocusGaided(FocusEvent evy){
        setBorder(new BorderLineRound(radius,1,color_G,false));
        repaint();
    }

    /**
     * Evento cuando pierde foco
     * @param evy
     */
    public void txtFocuslost(FocusEvent evy){
        actualizarBorde();
        repaint();
    }

    /**
     * Pintado del fondo redondeado
     */
    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);

        // Crear clip redondeado
        g2.setClip(new java.awt.geom.RoundRectangle2D.Double(
            0, 0, getWidth(), getHeight(), radius, radius));

        // Pintar fondo
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        super.paintComponent(g2);

        g2.dispose();
    }
}