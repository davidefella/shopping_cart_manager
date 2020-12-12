package shopping.cart.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopping.cart.model.CartResult;
import shopping.cart.model.ShoppingCart;
import shopping.cart.taxes_calculator.TaxesCalculator;

@Service
public class ShoppingCartManager {

    @Autowired
    TaxesCalculator taxesCalculator;

    public CartResult buyGoods(ShoppingCart shoppingCart ){
        CartResult cartResult = new CartResult(); 
        
        cartResult = taxesCalculator.computeTaxes(shoppingCart,cartResult );

        return cartResult;
    }
}