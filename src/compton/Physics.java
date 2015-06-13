package compton;

/**
 * Created by Kamil on 2015-06-13.
 */
public class Physics {

    public static final int C = 0; // speed of light

    /**
     * The Klein-Nishin formula
     *
     * @param e energia fotonu przed rozproszeniem
     * @param me masa spoczynkowa elektronu
     * @param fi k¹t rozproszenia fotonu
     * @return energia fotonu po rozproszeniu
     */
    public static double getEnergyAfter(double e, double me, double fi){
        return e / (1 + (e/(me*C*C)) * (1-Math.cos(fi)) );
    }
}
