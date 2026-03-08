package components;

import borders.BorderLineRound;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * JLabel personalizado con fondo y borde redondeado.
 * Permite mostrar texto o imagen dentro de un contenedor circular o redondeado.
 * 
 * @author Diego Alexander Gaviria Jimenez
 */
public class Jlabel extends JLabel {

    private String nombre = "";
    private ImageIcon icono = null;

    // radio del borde
    private int radius = 110;

    /**
     * Constructor vacío.
     */
    public Jlabel() {
        InitComponent();
    }
    
    /**
     * permite crear un JLabel redondo con borde.
     *
     * @param texto texto del JLabel
     * @param radius radio del borde redondeado
     * @param thickness grosor del borde
     * @param color color del borde
    */
    public Jlabel(String texto, int radius, int thickness, Color color) {
        this.nombre = texto;
        this.radius = radius;
        InitComponent();

       //Aplicar borde reutilizable
       setBorder(new BorderLineRound(radius, thickness, color));   
   } 
    
    /**
     * Constructor con texto.
     * 
     * @param info texto del JLabel
     */
    public Jlabel(String info) {
        this.nombre = info;
        InitComponent();
    }

    /**
     * Constructor con imagen.
     * 
     * @param info imagen del JLabel
     */
    public Jlabel(ImageIcon info) {
        this.icono = info;
        InitComponent();
    }

    /**
     * Inicializa las propiedades del componente.
     */
    private void InitComponent() {

        setText(nombre);
        setIcon(icono);

        setHorizontalAlignment(CENTER);
        setVerticalAlignment(CENTER);

        setOpaque(false); // importante para pintar fondo personalizado

        setPreferredSize(new Dimension(100, 100));

    }

    /**
     * Pinta el fondo redondeado del JLabel.
     * 
     * @param g objeto gráfico usado para renderizar el componente
     */
    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        // color de fondo
        g2.setColor(getBackground());

        // dibuja el fondo redondo
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        g2.dispose();

        super.paintComponent(g);
    }
}