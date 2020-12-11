package shopping.cart.taxes_calculator;

import java.util.ArrayList;
import java.util.List;

import shopping.cart.model.CartResult;
import shopping.cart.model.Product;
import shopping.cart.model.ShoppingCart;

public class TaxesCalculator {
    
    public CartResult computeTaxes( ShoppingCart shoppingCart, CartResult cartResult){



        List<Product> products = shoppingCart.getGoods(); 
        List<Product> productsResult = new ArrayList<>(); 
        double totalTaxes = 0.0; 

        cartResult.setIdShoppingCart("Shopping Cart nr. 4");
        cartResult.setTotalTaxes(20.5);

        for(Product p : products){
            productsResult.add( new Product( p.getName(), p.getQuantity(), p.getPrice()*p.getQuantity() ));
            
            totalTaxes = totalTaxes + this.calculateTax(p);

            cartResult.setTotalAmount( cartResult.getTotalAmount() + (p.getPrice()*p.getQuantity()) );
        }
       
        //cartResult.setTotalAmount( cartResult.getTotalAmount() + totalTaxes );

        cartResult.setProducts(productsResult);
        cartResult.setTotalTaxes(totalTaxes);

        return cartResult;
    }


    private double calculateTax(Product product){

        return product.getPrice();
    }

}