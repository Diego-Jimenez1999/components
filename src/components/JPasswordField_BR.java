package components;

import borders.BorderLineRound;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

/**
 * Componente personalizado basado en JPasswordField
 * que implementa un borde redondeado reutilizando BorderLineRound.
 * 
 * Características:
 * - Bordes redondeados configurables
 * - Cambio de color cuando recibe foco
 * - Fondo redondeado con antialiasing
 * - Botón de ojo para mostrar / ocultar contraseña
 * - Reutilización del borde BorderLineRound
 * 
 * Autor: Diego Alexander Gaviria
 */
public class JPasswordField_BR extends JPasswordField {

    private Dimension dimension = new Dimension(250,28);

    private int radius = 30;

    private Color colorInicial = Color.LIGHT_GRAY.darker();

    private Color colorFocus = new Color(109,109,109);

    /** Checkbox usado como botón de ojo */
    private JCheckBox ojo = new JCheckBox();

    /** Iconos */
    private ImageIcon iconOjoOff =
            new ImageIcon(getClass().getResource("/resources/Ojo_Desactivado.png"));

    private ImageIcon iconOjoOn =
            new ImageIcon(getClass().getResource("/resources/ojo_Activado.png"));

    /**
     * Constructor por defecto
     */
    public JPasswordField_BR() {
        initComponents();
    }

    /**
     * Constructor que define número de columnas
     * @param columns
     */
    public JPasswordField_BR(int columns) {
        super(columns);
        initComponents();
    }

    /**
     * Constructor con texto inicial
     * @param text
     */
    public JPasswordField_BR(String text) {
        super(text);
        initComponents();
    }

    /**
     * Constructor completo
     * @param text
     * @param columns
     */
    public JPasswordField_BR(String text, int columns) {
        super(text, columns);
        initComponents();
    }

    /**
     * Inicializa propiedades del componente
     */
    private void initComponents(){

        setOpaque(false);

        setBackground(Color.WHITE);
        
        setHorizontalAlignment(CENTER);//lo pone en el centro
        
        setPreferredSize(dimension);

        setFont(new Font("Century Gothic", Font.PLAIN, 12));

        // padding interno (espacio para el icono)
        setMargin(new Insets(5,12,5,35));

        setEchoChar('•');

        actualizarBorde();

        configurarOjo();

        addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                eventoFocusGained(e);
            }

            @Override
            public void focusLost(FocusEvent e) {
                eventoFocusLost(e);
            }
        });

    }

    /**
     * Configura el botón de ojo
     */
    private void configurarOjo(){

        setLayout(new BorderLayout());

        ojo.setIcon(iconOjoOff);

        ojo.setFocusable(false);

        ojo.setBorder(null);

        ojo.setContentAreaFilled(false);

        ojo.setCursor(new Cursor(Cursor.HAND_CURSOR));

        add(ojo, BorderLayout.EAST);

        ojo.addActionListener((ActionEvent e) -> {

            if(ojo.isSelected()){

                setEchoChar((char)0);

                ojo.setIcon(iconOjoOn);

            }else{

                setEchoChar('•');

                ojo.setIcon(iconOjoOff);
            }
        });

    }

    /**
     * Actualiza el borde con el color inicial
     */
    private void actualizarBorde(){

        setBorder(new BorderLineRound(radius,1,colorInicial,false));

    }

    /**
     * Evento cuando recibe foco
     * 
     */
    private void eventoFocusGained(FocusEvent e){

        setBorder(new BorderLineRound(radius,1,colorFocus,false));

        repaint();

    }

    /**
     * Evento cuando pierde foco
     */
    private void eventoFocusLost(FocusEvent e){

        actualizarBorde();

        repaint();

    }

    /**
     * Retorna el radio del borde
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
     * Retorna el color del borde cuando tiene foco
     * @return 
     */
    public Color getColorFocus() {
        return colorFocus;
    }

    /**
     * Cambia el color del borde cuando tiene foco
     * @param colorFocus
     */
    public void setColorFocus(Color colorFocus) {

        this.colorFocus = colorFocus;

    }

    /**
     * Pintado personalizado para fondo redondeado
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