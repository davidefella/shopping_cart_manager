package shopping.cart.taxes_calculator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopping.cart.ProductsUtils.CouponManager;
import shopping.cart.ProductsUtils.CurrencyManager;
import shopping.cart.ProductsUtils.ProductCategoryDetector;
import shopping.cart.model.CartResult;
import shopping.cart.model.Product;
import shopping.cart.model.ShoppingCart;
import shopping.cart.model.coupon_category.Coupon;
import shopping.cart.model.product_category.Category;
import shopping.cart.ProductsUtils.RounderDecimal;


@Service
public class TaxesCalculator {

    @Autowired
    ProductCategoryDetector productCategoryDetector;

    @Autowired
    CouponManager couponManager;
    
    @Autowired
    CurrencyManager currencyManager; 

    public CartResult computeTaxes(ShoppingCart shoppingCart, CartResult cartResult) {

        List<Product> products = shoppingCart.getGoods();

        if( shoppingCart.getGoods() == null || shoppingCart.getGoods().isEmpty())
            return new CartResult(); 

        List<Product> productsResult = new ArrayList<>();
        double totalTaxes = 0.0;

        Product productResult; 
        for (Product p : products) {

            productResult = createProductReturn(p, shoppingCart.getCodeCoupon());
            productsResult.add(new Product(productResult.getName(), productResult.getQuantity(), productResult.getPrice() * productResult.getQuantity()));
            cartResult.setTotalAmount( cartResult.getTotalAmount() + ( productResult.getPrice() * productResult.getQuantity()));
            totalTaxes = totalTaxes + this.calculateTax(productResult);
        }

        cartResult.setIdShoppingCart(shoppingCart.getIdShoppingCart());
        cartResult.setProducts(productsResult);
        cartResult.setCurrency(currencyManager.getDefaultCurrency()); 
        cartResult.setTotalTaxes(totalTaxes);
        cartResult.setTotalAmount(cartResult.getTotalAmount() + totalTaxes);

        return cartResult;
    }

    // note: is public for testing purpose
    public double calculateTax(Product product) {

        Category productCategory = productCategoryDetector.detectCategoryFrom(product.getName());
        double totalPrice = product.getQuantity() * product.getPrice();
        double totalTaxesProduct = (totalPrice * (productCategory.getPercentage() / 100.00));

        return RounderDecimal.formatDecimals(totalTaxesProduct); 
    }

    private Product createProductReturn(Product inputProduct, String codeCoupon) {
        Product productResult = new Product();
        double priceUpdated = inputProduct.getPrice(); 

        Coupon coupon = couponManager.getcoupon(codeCoupon, inputProduct.getName()); 
        
        if(coupon != null) {
            double discountRate = coupon.getPercentage()/100.00; 
            priceUpdated = inputProduct.getPrice() * ( 1 - discountRate );
        }

        productResult.setPrice(priceUpdated);
        productResult.setName(inputProduct.getName());
        productResult.setQuantity(inputProduct.getQuantity());

        return productResult;
    }
}