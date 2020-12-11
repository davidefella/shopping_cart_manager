package shopping.cart.manager.model;

import java.util.List;


public class ShoppingCart {
    
    String idShoppingCart; 
    List<Product> goods;

    public String getIdShoppingCart() {
        return idShoppingCart;
    }

    public void setIdShoppingCart(String idShoppingCart) {
        this.idShoppingCart = idShoppingCart;
    }

    public List<Product> getGoods() {
        return goods;
    }

    public void setGoods(List<Product> goods) {
        this.goods = goods;
    }

}
