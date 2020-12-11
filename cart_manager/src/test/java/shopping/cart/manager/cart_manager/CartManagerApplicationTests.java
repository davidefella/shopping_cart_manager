package shopping.cart.manager.cart_manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import shopping.cart.manager.ShoppingCartManager;
import shopping.cart.model.CartResult;
import shopping.cart.model.Product;
import shopping.cart.model.ShoppingCart;

@SpringBootTest
class CartManagerApplicationTests {

    @Autowired
	private ShoppingCartManager shoppingCartManager;


    @Test
    public void BuyGoods_CartExample1_Return() throws Exception {
        //arrange
        ShoppingCart shoppingCart = new ShoppingCart();
        List<Product> products = new ArrayList<>(); 
        shoppingCart.setGoods(products);
        Product p1 = new Product("beer", 5, 2); 
        Product p2 = new Product("pen", 1, 1.35);
        Product p3 = new Product("t-shirts", 10, 4);
        products.add(p1);
        products.add(p2);
        products.add(p3);

        //act 
        CartResult cartResult = shoppingCartManager.buyGoods(shoppingCart);

        //result
        assertTrue(searchForName(cartResult.getProducts(), "beer"));
        assertTrue(searchForName(cartResult.getProducts(), "pen"));
        assertTrue(searchForName(cartResult.getProducts(), "t-shirts"));
        assertEquals(cartResult.getProducts().size(), 3);
    }


    @Test
    public void BuyGoods_CartExample2_Return() throws Exception {
        //arrange
        ShoppingCart shoppingCart = new ShoppingCart();
        List<Product> products = new ArrayList<>(); 
        shoppingCart.setGoods(products);
        Product p1 = new Product("cokes", 2, 2.30); 
        Product p2 = new Product("knitwear", 1, 33);
        Product p3 = new Product("books", 3, 12.99);
        products.add(p1);
        products.add(p2);
        products.add(p3);

        //act 
        CartResult cartResult = shoppingCartManager.buyGoods(shoppingCart);

        //result
        assertTrue(searchForName(cartResult.getProducts(), "cokes"));
        assertTrue(searchForName(cartResult.getProducts(), "knitwear"));
        assertTrue(searchForName(cartResult.getProducts(), "books"));
        assertEquals(cartResult.getProducts().size(), 3);
    } 

   
    @Test
    public void BuyGoods_CartExample3_Return() throws Exception {
        //arrange
        ShoppingCart shoppingCart = new ShoppingCart();
        List<Product> products = new ArrayList<>(); 
        shoppingCart.setGoods(products);
        Product p1 = new Product("cake", 1, 42.50); 
        Product p2 = new Product("book", 1, 16.57);
        Product p3 = new Product("t-shirts", 7, 5.40);
        Product p4 = new Product("book", 1, 12.93);
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);

        //act 
        CartResult cartResult = shoppingCartManager.buyGoods(shoppingCart);

        //result
        assertTrue(searchForName(cartResult.getProducts(), "cake"));
        assertTrue(searchForName(cartResult.getProducts(), "book"));
        assertTrue(searchForName(cartResult.getProducts(), "t-shirts"));
        assertEquals(cartResult.getProducts().size(), 4);
    }


    /** Auxiliary Methods */

    private boolean searchForName(List<Product> products, String name2search){
        boolean isNamePresent = false; 

        for(Product p : products){
            if(p.getName().equals(name2search))
                return true; 
        }

        return isNamePresent;
    }

}
