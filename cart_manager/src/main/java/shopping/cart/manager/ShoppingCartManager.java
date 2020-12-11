package shopping.cart.manager;

import shopping.cart.model.CartResult;
import shopping.cart.model.ShoppingCart;

public class ShoppingCartManager {

    public CartResult buyGoods(ShoppingCart shoppingCart ){
        CartResult cartResult = new CartResult(); 

        cartResult.setIdShoppingCart("Shopping Cart nr.");
        cartResult.setProducts(shoppingCart.getGoods());
        cartResult.setTotalAmount(150);
        cartResult.setTotalTaxes(20.5);

        return cartResult;
    }
}