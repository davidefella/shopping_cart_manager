package shopping.cart.model;

import java.util.List;

public class ShoppingCart {
    
    String idShoppingCart;
    String codeCoupon; 

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

    public String getCodeCoupon() {
        return codeCoupon;
    }

    public void setCodeCoupon(String codeCoupon) {
        this.codeCoupon = codeCoupon;
    }

  

}
