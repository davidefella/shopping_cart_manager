package shopping.cart.manager;

import org.springframework.stereotype.Service;

import shopping.cart.model.CartResult;
import shopping.cart.model.ShoppingCart;
import shopping.cart.taxes_calculator.TaxesCalculator;

@Service
public class ShoppingCartManager {

    public CartResult buyGoods(ShoppingCart shoppingCart ){
        TaxesCalculator taxesCalculator = new TaxesCalculator(); 
        CartResult cartResult = new CartResult(); 
        
        cartResult = taxesCalculator.computeTaxes(shoppingCart,cartResult );

        return cartResult;
    }
}