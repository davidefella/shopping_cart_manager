package shopping.cart.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RounderDecimal {

    public double formatDecimals(double number) {
        BigDecimal bigDecimal = new BigDecimal(Double.toString(number));
        
        bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);

        return bigDecimal.doubleValue();
    }
}
