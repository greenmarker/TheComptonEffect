package compton.utils;

import java.text.NumberFormat;
import java.text.ParseException;

/**
 * Created by Kamil on 2015-06-16.
 */
public class Utils {

    /**
     *
     * @param valueInString this string should contain a number
     * @return
     */
    public static double parseDouble(String valueInString){
        if (""==valueInString) return 0;
        NumberFormat nf = NumberFormat.getInstance(); // default locale
        try {
            return nf.parse(valueInString).doubleValue();
        } catch (ParseException e) {
            //e.printStackTrace();
            return 0;
        }
    }
}
