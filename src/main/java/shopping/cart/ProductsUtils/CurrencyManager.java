package shopping.cart.ProductsUtils;

import org.springframework.stereotype.Service;

@Service
public class CurrencyManager {
    private final String DEFAULT_CURRENCY = ConstantsString.EUR_CURRENCY; 

    public String getDefaultCurrency(){
        return DEFAULT_CURRENCY; 
    }
}