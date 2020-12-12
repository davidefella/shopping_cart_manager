package shopping.cart.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Service;

@Service
public class RounderDecimal {

    public double formatDecimals(double number) {
        BigDecimal bigDecimal = new BigDecimal(Double.toString(number));
        
        bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);

        return bigDecimal.doubleValue();
    }
}
