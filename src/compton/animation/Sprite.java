package compton.animation;

import java.awt.*;

/**
 * Created by Kamil on 2015-06-14.
 */
public class Sprite {

    private int amplitudeBefore = 20; //amplituda przed efektem Comptona
    private int angle = 45;
    private int amplitudeAfter = 15; // amplitude after the Compton Effect
    private int frequency = 2;	//częstotliwość
    private int x0;

    //private final Dimension size = new Dimension(768, 494);//(szerokość(width),wysokość(height))
    private int x = 0; //deklaracja x w momencie początkowym
    private int yBase = 0;



    public Sprite(int amplitudeBefore, int angle, int amplitudeAfter, int frequency, int x0){
        super();
        this.amplitudeBefore = amplitudeBefore;
        this.angle = angle;
        this.amplitudeAfter = amplitudeAfter;
        this.frequency = frequency;
        this.x0 = x0;
    }

    public void setX0(int x0){
        this.x0 = x0;
    }

    public void paintComponent(Graphics2D g2) {
        //System.out.println("x0:" + x0 + ", x:" + x);
        drawFunction(g2, new Function(){
            @Override
            public double f(double x) {
                return Math.sin(x);
            }
        }, amplitudeBefore, angle, amplitudeAfter, 50, x0 + x);
    }

    /**
     *
     * @param g2
     * @param f
     * @param amplitudeBefore
     * @param angle
     * @param amplitudeAfter
     * @param wavelength
     * @param mx end of the wave
     */
    public void drawFunction(Graphics2D g2, Function f, double amplitudeBefore, double angle, double amplitudeAfter, double wavelength, int mx){

        if (mx<0) {
            Polygon p = new Polygon();
            int startx = (int)(mx-wavelength);
            if (startx<x0) startx = x0;

            //System.out.println("mx-wavelength:" + (mx-wavelength) + ", x0:" + x0);

            for (int x = startx; x <= mx; x++) {
                double amplitude = amplitudeBefore;
                p.addPoint(x, (int) (amplitude / 2 * f.f((x / amplitude) * 2 * Math.PI)));
            }
            g2.setColor(Color.red);
            g2.drawPolyline(p.xpoints, p.ypoints, p.npoints);

        } else {

            // wave
            Polygon p = new Polygon();
            int endx = (int)(mx + wavelength);
            if (endx>-x0) endx = -x0;
            for (int x = mx; x <= endx; x++) {
                double amplitude = amplitudeAfter;
                p.addPoint(x, (int) (amplitude / 2 * f.f((x / amplitude) * 2 * Math.PI)));
            }
            g2.setColor(Color.red);
            g2.rotate(Math.toRadians(angle), 0, 0);
            g2.drawPolyline(p.xpoints, p.ypoints, p.npoints);
            g2.rotate(Math.toRadians(-angle), 0, 0);

            // ball
            if (mx<-x0-10) {
                g2.rotate(Math.toRadians(-angle), 0, 0);
                g2.setColor(Color.RED);//kulka
                g2.fillOval(mx, (int) 0, 20, 20);
                g2.rotate(Math.toRadians(angle), 0, 0);
            }
        }
    }

    public void fotonsinusiod1() {

        //Przenies piksel w prawo; Pętla na po lewej stronie po osiągnięciu krawędzi
        x = (++x) % Math.abs(2* x0);
    }
}
