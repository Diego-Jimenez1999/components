package components;

import borders.BorderLineRound;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

/**
 * JButtonsBr
 * Botón moderno reutilizando BorderLineRound
 * Compatible con los otros componentes del sistema UI.
 * 
 * Características:
 * - Bordes redondeados reutilizando BorderLineRound
 * - Hover animado
 * - Ripple effect
 * - Colores configurables
 * 
 * Autor: Diego Alexander Gaviria
 */
public class JButtonsBr extends JButton {

    private Color backgroundColor = new Color(44, 62, 80);
    private Color hoverColor = new Color(52, 73, 94);
    private Color clickColor = new Color(31, 45, 58);
    private Color borderColor = new Color(27, 38, 49);

    private Color rippleColor = new Color(255,255,255,100);

    private Color currentColor;

    private int radius = 30;

    private int borderThickness = 2;

    private boolean hovering = false;
    private boolean pressed = false;

    private Timer hoverTimer;

    // Ripple
    private int rippleRadius = 0;
    private int rippleX, rippleY;
    private boolean rippleActive = false;

    /* =========================
       CONSTRUCTORES
       ========================= */

    public JButtonsBr() {
        this("Button");
    }

    public JButtonsBr(String text) {
        super(text);
        initialize();
    }

    public JButtonsBr(String text, int width, int height) {
        super(text);
        setPreferredSize(new Dimension(width,height));
        initialize();
    }

    /* =========================
       INICIALIZACIÓN
       ========================= */

    private void initialize(){

        currentColor = backgroundColor;

        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(false);

        setForeground(Color.WHITE);

        setFont(new Font("Century Gothic",Font.BOLD,12));

        actualizarBorde();

        initHoverAnimation();

        initRippleEffect();
    }

    /**
     * Aplica el borde reutilizable
     */
    private void actualizarBorde(){

        setBorder(new BorderLineRound(radius,borderThickness,borderColor,true));

    }

    /* =========================
       HOVER ANIMADO
       ========================= */

    private void initHoverAnimation(){

        hoverTimer = new Timer(10,e->{

            if(pressed){
                currentColor = blend(currentColor,clickColor,0.2f);
            }
            else if(hovering){
                currentColor = blend(currentColor,hoverColor,0.1f);
            }
            else{
                currentColor = blend(currentColor,backgroundColor,0.1f);
            }

            repaint();
        });

        hoverTimer.start();

        addMouseListener(new MouseAdapter(){

            @Override
            public void mouseEntered(MouseEvent e){
                hovering = true;
            }

            @Override
            public void mouseExited(MouseEvent e){
                hovering = false;
                pressed = false;
            }

            @Override
            public void mousePressed(MouseEvent e){
                pressed = true;
                startRipple(e.getX(),e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e){
                pressed = false;
            }

        });
    }

    /* =========================
       RIPPLE EFFECT
       ========================= */

    private void initRippleEffect(){

        Timer rippleTimer = new Timer(15,e->{

            if(rippleActive){

                rippleRadius += 8;

                if(rippleRadius > getWidth()){
                    rippleActive = false;
                    rippleRadius = 0;
                }

                repaint();
            }

        });

        rippleTimer.start();
    }

    private void startRipple(int x,int y){

        rippleX = x;
        rippleY = y;

        rippleRadius = 0;

        rippleActive = true;
    }

    /* =========================
       PINTADO
       ========================= */

    @Override
    protected void paintComponent(Graphics g){

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        // Fondo redondeado
        g2.setColor(currentColor);
        g2.fillRoundRect(
                borderThickness,
                borderThickness,
                width - borderThickness*2,
                height - borderThickness*2,
                radius,
                radius);

        // Ripple
        if(rippleActive){

            g2.setColor(rippleColor);

            g2.fillOval(
                    rippleX - rippleRadius/2,
                    rippleY - rippleRadius/2,
                    rippleRadius,
                    rippleRadius);
        }

        g2.dispose();

        super.paintComponent(g);
    }

    /* =========================
       MÉTODO DE MEZCLA
       ========================= */

    private Color blend(Color c1, Color c2, float ratio){

        float ir = 1.0f - ratio;

        return new Color(
                (int)(c1.getRed()*ir + c2.getRed()*ratio),
                (int)(c1.getGreen()*ir + c2.getGreen()*ratio),
                (int)(c1.getBlue()*ir + c2.getBlue()*ratio)
        );
    }

    /* =========================
       GETTERS / SETTERS
       ========================= */

    public void setRadius(int radius){

        this.radius = radius;

        actualizarBorde();

        repaint();
    }

    public int getRadius(){
        return radius;
    }

    public void setBorderColor(Color color){

        this.borderColor = color;

        actualizarBorde();

    }

    public Color getBorderColor(){
        return borderColor;
    }

}