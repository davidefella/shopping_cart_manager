package shopping.cart.ProductsUtils;

import org.springframework.stereotype.Service;
import shopping.cart.model.product_category.Basic;
import shopping.cart.model.product_category.Book;
import shopping.cart.model.product_category.Category;
import shopping.cart.model.product_category.FoodBeverage;

@Service
public class ProductCategoryDetector {

    public Category detectCategoryFrom(String nameProduct) {

        if (isFood(nameProduct))
            return new FoodBeverage();

        if (isBook(nameProduct))
            return new Book();

        return new Basic();
    }

    private boolean isFood(String nameProduct) {
        if (nameProduct.contains("beer") || nameProduct.contains("cake") || nameProduct.contains("coke") || nameProduct.contains("wine"))
            return true;
        else
            return false;
    }

    private boolean isBook(String nameProduct) {
        if (nameProduct.contains("book"))
            return true;
        else
            return false;
    }
}
