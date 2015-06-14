package compton.animation;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;


public class SinusoidComponent extends JPanel
{

    private final Dimension size = new Dimension(768, 494);//(szerokość(width),wysokość(height))

    private Sprite sprite;

    public SinusoidComponent() {
        super(true);
        startAnimation();
    }

    private void startAnimation(){
        final SinusoidComponent.Sinusoider t = new Sinusoider(this);
        final SinusoidComponent.Repainter r = new Repainter(this);

        final Timer tickTimer = new Timer();
        final Timer paintTimer = new Timer();

        paintTimer.schedule(r, 1000, 50);
        tickTimer.schedule(t, 1000, 10);
    }


    @Override
    protected void paintComponent(final Graphics g) { //rysowanie
        final Graphics2D g2 = (Graphics2D) g;

        g2.translate(getWidth() / 2, getHeight() / 2);

        drawBackground(g2);
        drawSprite(g2);

        //g2.setColor(Color.BLACK);//kulka
        //g2.fillOval(x, (int)y, 20, 20);

        //g2.setColor(Color.BLACK);//kulka
        //g2.fillOval(x1, (int)y1, 20, 20);

        drawElectron(g2);

        // restore
        g2.translate(getWidth() / 2, getHeight() / 2);
    }

    private Sprite getSprite(){
        if (sprite==null){
            sprite = new Sprite(20, 2, -getRadius());
        }
        return sprite;
    }

    private void drawSprite(Graphics2D g2){
        getSprite().paintComponent(g2);
    }

    private void drawElectron(Graphics2D g2) {
        int re = (int)(getRadius() * 0.05);
        g2.setColor(Color.WHITE);
        g2.fillOval(-re, -re, 2 * re, 2 * re);
        g2.setColor(Color.BLACK);
        g2.drawOval(-re, -re, 2*re, 2*re);
    }

    private int getRadius(){
        return Math.min(getWidth(), getHeight())/2;
    }

    private void drawBackground(Graphics2D g2){
        g2.setColor(Color.WHITE);//obszar animacji
        g2.fillRect(-getWidth()/2, -getHeight()/2, getWidth(), getHeight());

        int r = getRadius();

        g2.setColor(Color.GRAY);
        g2.drawOval(-r, -r, 2*r, 2*r);

        g2.setColor(new Color(210, 210, 210));
        g2.drawLine(0, -r, 0, r); //  |
        g2.drawLine(-r, 0, r, 0); // ---
    }

    public static class Sinusoider extends TimerTask {

        private final SinusoidComponent panel;

        public Sinusoider(final SinusoidComponent panel) {
            this.panel = panel;
        }

        @Override
        public void run() {
            panel.getSprite().fotonsinusiod1();
        }

    }

    public static class Repainter extends TimerTask {

        private final SinusoidComponent panel;

        public Repainter(final SinusoidComponent panel) {
            this.panel = panel;
        }

        @Override
        public void run() {
            panel.repaint();
        }

    }
}