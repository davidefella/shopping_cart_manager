package shopping.cart.taxes_calculator;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopping.cart.model.CartResult;
import shopping.cart.model.Product;
import shopping.cart.model.ShoppingCart;
import shopping.cart.model.product_category.Category;
import shopping.cart.utils.ProductCategoryDetector;
import shopping.cart.utils.RounderDecimal;

@Service
public class TaxesCalculator {

    @Autowired
    ProductCategoryDetector productCategoryDetector;

    @Autowired
    RounderDecimal rounderDecimal;

    public CartResult computeTaxes(ShoppingCart shoppingCart, CartResult cartResult) {

        List<Product> products = shoppingCart.getGoods();
        List<Product> productsResult = new ArrayList<>();
        double totalTaxes = 0.0;

        for (Product p : products) {
            productsResult.add(new Product(p.getName(), p.getQuantity(), p.getPrice() * p.getQuantity()));

            totalTaxes = totalTaxes + this.calculateTax(p);

            cartResult.setTotalAmount(cartResult.getTotalAmount() + (p.getPrice() * p.getQuantity()));
        }

        cartResult.setIdShoppingCart("Shopping Cart nr. 4");
        cartResult.setProducts(productsResult);
        cartResult.setTotalTaxes(totalTaxes);
        cartResult.setTotalAmount(cartResult.getTotalAmount() + totalTaxes);

        return cartResult;
    }

    private double calculateTax(Product product) {

        Category productCategory = productCategoryDetector.detectCategoryFrom(product.getName());
        double totalPrice = product.getQuantity() * product.getPrice();
        double totalTaxesProduct = (totalPrice * (productCategory.getPercentage() / 100.00));

        return rounderDecimal.formatDecimals(totalTaxesProduct);
    }
}