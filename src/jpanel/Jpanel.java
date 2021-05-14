package jpanel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

/**
 *
 * @author Diego Alexander Gaviria Jimenez
 */
public class Jpanel extends JPanel {

    private int arcw = 30;
    private int arch = 30;

    public Jpanel() {
        super();
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        Paint oldPaint = g2.getPaint();
        RoundRectangle2D.Float r2d = new RoundRectangle2D.Float(
                0, 0, getWidth(), getHeight() - 1, getArcw(), getArch());
        g2.clip(r2d);
        g2.setPaint(new GradientPaint(0.0f, 0.0f, getBackground(),
                0.0f, getHeight(), getBackground()));
        g2.fillRect(0, 0, getWidth(), getHeight());

        g2.setStroke(new BasicStroke(4f));
        g2.setPaint(new GradientPaint(0.0f, 0.0f, getBackground(),
                0.0f, getHeight(), getBackground()));
        g2.drawRoundRect(0, 0, getWidth() - 2, getHeight() - 2, 18, 18);

        g2.setPaint(oldPaint);
        super.paintComponent(g);
    }

    public int getArcw() {
        return arcw;
    }

    public void setArcw(int arcw) {
        this.arcw = arcw;
    }

    public int getArch() {
        return arch;
    }

    public void setArch(int arch) {
        this.arch = arch;
    }
}
