package compton.gui.common.animation;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

import compton.AppConstants;
import compton.gui.GuiReferenceHolder;
import compton.gui.IParamsSource;

/**
 * Created by Kamil on 2015-06-14.
 */
public class Sprite {

    private double amplitude = AppConstants.AMPLITUDE; //amplituda przed efektem Comptona
    private double angle = 45;
    private int frequency = 2;	//częstotliwość
    private int x0;

    //private final Dimension size = new Dimension(768, 494);//(szerokość(width),wysokość(height))
    private int x = 0; //deklaracja x w momencie początkowym
    private int yBase = 0;



    public Sprite(int x0){
        super();
        tryReadingParameters();
        this.x0 = x0;
    }

    public void tryReadingParameters(){
    	IParamsSource gui = GuiReferenceHolder.gui;
        if (gui!=null){
            // read parameters from Main frame
            angle = gui.getAngle();
        }
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
        }, amplitude, angle, 50, x0 + x);
    }

    /**
     *
     * @param g2
     * @param f
     * @param amplitudeBefore
     * @param angle
     * @param wavelength
     * @param mx end of the wave
     */
    public void drawFunction(Graphics2D g2, Function f, double amplitudeBefore, double angle, double wavelength, int mx){
        //System.out.println("mx:"+mx);
        if (mx<0) {
            Polygon p = new Polygon();
            int startx = (int)(mx-wavelength);
            if (startx<x0) startx = x0;

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
                double amplitude = amplitudeBefore;
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

        if (x==0){
            tryReadingParameters();
        }
    }
}
