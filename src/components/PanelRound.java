package components;

import borders.BorderLineRound;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * JPanel personalizado con soporte para bordes redondeados,
 * grosor de borde, color y sombra.
 */
public class PanelRound extends JPanel {

    private int radius = 20;
    private int borderWidth = 0;
    private Color borderColor = Color.GRAY;
    private boolean shadow = false;

    /**
     * Constructor por defecto.
     */
    public PanelRound() {
        initComponents();
    }

    /**
     * Constructor con radio.
     * 
     * @param radius radio de las esquinas
     */
    public PanelRound(int radius) {
        this.radius = radius;
        initComponents();
    }

    /**
     * Inicializa las propiedades del componente.
     */
    private void initComponents() {
        setOpaque(false);
        updateBorder();
        setBackground(Color.WHITE);
        
    }

    /**
     * Actualiza el borde del componente.
     */
    private void updateBorder() {
        setBorder(new BorderLineRound(radius, borderWidth, borderColor, shadow));
        repaint();
    }

    /**
     * Establece el radio de las esquinas.
     * 
     * @param radius nuevo radio
     */
    public void setRadius(int radius) {
        this.radius = radius;
        updateBorder();
    }

    /**
     * Obtiene el radio actual.
     * 
     * @return radio de las esquinas
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Establece el grosor del borde.
     * 
     * @param borderWidth grosor del borde
     */
    public void setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
        updateBorder();
    }

    /**
     * Obtiene el grosor del borde.
     * 
     * @return grosor del borde
     */
    public int getBorderWidth() {
        return borderWidth;
    }

    /**
     * Establece el color del borde.
     * 
     * @param borderColor color del borde
     */
    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        updateBorder();
    }

    /**
     * Obtiene el color del borde.
     * 
     * @return color del borde
     */
    public Color getBorderColor() {
        return borderColor;
    }

    /**
     * Activa o desactiva la sombra.
     * 
     * @param shadow true para activar sombra
     */
    public void setShadow(boolean shadow) {
        this.shadow = shadow;
        updateBorder();
    }

    /**
     * Indica si la sombra está activa.
     * 
     * @return estado de la sombra
     */
    public boolean isShadow() {
        return shadow;
    }

    /**
     * Dibuja el fondo redondeado del panel.
     */
    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        int offset = borderWidth;

        g2.setColor(getBackground());
        g2.fillRoundRect(
                offset,
                offset,
                getWidth() - offset * 2,
                getHeight() - offset * 2,
                radius,
                radius
        );

        g2.dispose();

        super.paintComponent(g);
    }
}