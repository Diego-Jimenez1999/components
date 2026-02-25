package Buttons;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.border.AbstractBorder;

/**
 * Border personalizado que dibuja un borde redondeado alrededor
 * de cualquier componente Swing.
 *
 * Permite configurar:
 * - Color del borde
 * - Grosor del borde
 * - Radio de las esquinas
 */
public class BorderLineRound extends AbstractBorder {

    // ==============================
    // ATRIBUTOS PRIVADOS
    // ==============================

    private Color borderColor = new Color(200, 200, 200);
    private float borderWidth = 2f;
    private int cornerRadius = 30;

    /**
     * Constructor por defecto.
     */
    public BorderLineRound() {
    }

    /**
     * Constructor parametrizado.
     *
     * @param borderColor Color del borde.
     * @param borderWidth Grosor del borde.
     * @param cornerRadius Radio de las esquinas.
     */
    public BorderLineRound(Color borderColor, float borderWidth, int cornerRadius) {
        this.borderColor = borderColor;
        this.borderWidth = borderWidth;
        this.cornerRadius = cornerRadius;
    }

    /**
     * Método que dibuja el borde del componente.
     *
     * @param c Componente al que se aplica el borde.
     * @param g Contexto gráfico.
     * @param x Coordenada X inicial.
     * @param y Coordenada Y inicial.
     * @param width Ancho del componente.
     * @param height Alto del componente.
     */
    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {

        Graphics2D g2 = (Graphics2D) g.create();

        // Activar antialiasing para suavizar bordes
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // Configurar grosor del borde
        g2.setStroke(new BasicStroke(borderWidth));

        // Crear forma redondeada
        RoundRectangle2D round = new RoundRectangle2D.Float(
                x,
                y,
                width - 1,
                height - 1,
                cornerRadius,
                cornerRadius
        );

        // Dibujar borde
        g2.setColor(borderColor);
        g2.draw(round);

        g2.dispose();
    }

    /**
     * Define los espacios internos (Insets) del borde.
     * Esto evita que el contenido del componente se superponga al borde.
     */
    @Override
    public Insets getBorderInsets(Component c) {
        int value = (int) Math.ceil(borderWidth);
        return new Insets(value, value, value, value);
    }

    /**
     * Indica si el borde es opaco.
     *
     * @return false porque el fondo no se pinta aquí.
     */
    @Override
    public boolean isBorderOpaque() {
        return false;
    }

    // ======================================
    // GETTERS Y SETTERS DOCUMENTADOS
    // ======================================

    /**
     * Obtiene el color actual del borde.
     *
     * @return Color del borde.
     */
    public Color getBorderColor() {
        return borderColor;
    }

    /**
     * Establece un nuevo color para el borde.
     *
     * @param borderColor Nuevo color.
     */
    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    /**
     * Obtiene el grosor del borde.
     *
     * @return Grosor actual.
     */
    public float getBorderWidth() {
        return borderWidth;
    }

    /**
     * Define el grosor del borde.
     * Debe ser mayor que cero.
     *
     * @param borderWidth Nuevo grosor.
     */
    public void setBorderWidth(float borderWidth) {
        if (borderWidth > 0) {
            this.borderWidth = borderWidth;
        }
    }

    /**
     * Obtiene el radio de las esquinas.
     *
     * @return Radio actual.
     */
    public int getCornerRadius() {
        return cornerRadius;
    }

    /**
     * Define el radio de las esquinas redondeadas.
     *
     * @param cornerRadius Nuevo radio.
     */
    public void setCornerRadius(int cornerRadius) {
        if (cornerRadius >= 0) {
            this.cornerRadius = cornerRadius;
        }
    }
}