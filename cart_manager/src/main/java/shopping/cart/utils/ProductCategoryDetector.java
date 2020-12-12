package shopping.cart.utils;

import shopping.cart.model.product_category.Basic;
import shopping.cart.model.product_category.Book;
import shopping.cart.model.product_category.Category;
import shopping.cart.model.product_category.FoodBeverage;

public class ProductCategoryDetector {

    public Category detectCategoryFrom(String nameProduct) {

        if (isFood(nameProduct))
            return new FoodBeverage();

        if (isBook(nameProduct))
            return new Book();

        return new Basic();
    }

    private boolean isFood(String nameProduct) {
        if (nameProduct.contains("beer") || nameProduct.contains("cake") || nameProduct.contains("coke"))
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
