package compton;

/**
 * Created by Kamil on 2015-06-13.
 */
public class Physics {

    public static final int C = 299_792_458; // m/s speed of light

    /**
     * @param e energia fotonu przed rozproszeniem [keV]
     * @param sourceEnergy masa spoczynkowa elektronu [keV]
     * @param fi k¹t rozproszenia fotonu [degrees]
     * @return energia fotonu po rozproszeniu [keV]
     */
    public static double getEnergyAfter(double e, double sourceEnergy, double fi){
        // The Klein-Nishin formula
        double licznik = e*(1- Math.cos(Math.toRadians(fi)));
        double energyAfter = e / (1 + (licznik/sourceEnergy) );
        //System.out.println("e:" + e + ", sourceEnergy:" + sourceEnergy + ", fi:" + fi + ",    licznik: " + licznik);
        return energyAfter;
    }
}
