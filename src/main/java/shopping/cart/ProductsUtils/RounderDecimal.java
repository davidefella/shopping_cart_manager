package shopping.cart.ProductsUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RounderDecimal {

    public static double formatDecimals(double number) {
        BigDecimal bigDecimal = new BigDecimal(Double.toString(number));
        
        bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);

        return bigDecimal.doubleValue();
    }

    public static String formatDecimals2String(double number) {
        BigDecimal bigDecimal = new BigDecimal(Double.toString(number));
        
        bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);

        return bigDecimal.toString();
    }    
}
