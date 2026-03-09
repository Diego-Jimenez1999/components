package borders;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.border.AbstractBorder;

/**
 * Borde personalizado con esquinas redondeadas configurable.
 */
public class BorderLineRound extends AbstractBorder {

    private int radius;
    private int borderWidth;
    private Color borderColor;
    private boolean shadow;

    /**
     * Constructor compatible con el código existente.
     * 
     * @param radius radio de las esquinas
     */
    public BorderLineRound(int radius) {
        this(radius, 1, Color.GRAY, false);
    }

    /**
     * Constructor con radio y grosor del borde.
     * 
     * @param radius radio de las esquinas
     * @param borderWidth grosor del borde
     */
    public BorderLineRound(int radius, int borderWidth) {
        this(radius, borderWidth, Color.GRAY, false);
    }
    
    /**
     * Constructor con radio y grosor del borde.
     * 
     * @param radius radio de las esquinas
     * @param borderWidth grosor del borde
     * @param color
    */
    public BorderLineRound(int radius, int borderWidth, Color color) {
        this(radius, borderWidth, color, false);
    }
      
    public BorderLineRound(Color borderColor, boolean shadow) {
    this.radius = 12;        // radio por defecto
    this.borderWidth = 1;    // grosor por defecto
    this.borderColor = borderColor;
    this.shadow = shadow;  
    
    }
    /**
     * Constructor completo.
     * 
     * 
     * @param radius radio de las esquinas
     * @param borderWidth grosor del borde
     * @param borderColor color del borde
     * @param shadow activar sombra
     */
    public BorderLineRound(int radius, int borderWidth, Color borderColor, boolean shadow) {
        this.radius = radius;
        this.borderWidth = borderWidth;
        this.borderColor = borderColor;
        this.shadow = shadow;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        // Dibujar sombra opcional
        if (shadow) {
            g2.setColor(new Color(0, 0, 0, 40));
            g2.fillRoundRect(
                    x + 2,
                    y + 2,
                    width - 1,
                    height - 1,
                    radius,
                    radius
            );
        }

        // Dibujar borde
        g2.setColor(borderColor);
        g2.setStroke(new BasicStroke(borderWidth));

        g2.drawRoundRect(
                x,
                y,
                width - borderWidth,
                height - borderWidth,
                radius,
                radius
        );

        g2.dispose();
    }

    
 
      
}