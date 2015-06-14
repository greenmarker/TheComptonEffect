package compton.animation;

import java.awt.*;

/**
 * Created by Kamil on 2015-06-14.
 */
public class Sprite {

    private int amplitude = 20; //amplituda
    private int frequency = 2;	//czêstotliwoœæ
    private int x0;

    private final Dimension size = new Dimension(768, 494);//(szerokoœæ(width),wysokoœæ(height))
    private int x = 0; //deklaracja x w momencie pocz¹tkowym
    private double y = size.height / 2; //deklaracja y
    private int yBase = 0;



    public Sprite(int amplitude, int frequency, int x0){
        super();
        this.amplitude = amplitude;
        this.frequency = frequency;
        this.x0 = x0;
    }

    public void paintComponent(Graphics2D g2) {
        //System.out.println("x0:" + x0 + ", x:" + x);
        drawFunction(g2, new Function(){
            @Override
            public double f(double x) {
                return Math.sin(x);
            }
        }, amplitude, 50, x0 + x);
    }

    public void drawFunction(Graphics2D g2, Function f, double amplitude, double wavelength, int mx){
        Polygon p = new Polygon();

        for (int x = mx; x <= mx + wavelength; x++) {
            p.addPoint(x, (int) (amplitude/2 * f.f((x / amplitude) * 2 * Math.PI)));
        }
        g2.setColor(Color.red);
        g2.drawPolyline(p.xpoints, p.ypoints, p.npoints);
    }

    public void fotonsinusiod1() {

        //Przenies piksel w prawo; Pêtla na po lewej stronie po osi¹gniêciu krawêdzi
        x = (++x) % 376;

        //D³ugoœæ fali = jeden pe³ny panel szerokoœæ podzielona przez czêstotliwoœæ
        final int waveLength = size.width / frequency;

        //Zwiêkszanie yBase; ograniczenie siê przy d³ugoœci fali
        yBase = (++yBase) % waveLength;

        //Normalizacja [0..1]
        final double normalized = (double)yBase / (double)waveLength;

        //Full wave at 2*pi, means...
        final double radians = normalized * Math.PI * 2;

        //Getting the sine
        final double sine = Math.sin(radians);

        //Multiplying with amplitude, add to center position and we have our y
        y = (int)(sine * amplitude) + size.height/2;

    }
}
