package shopping.cart.ProductsUtils;

import org.springframework.stereotype.Service;
import shopping.cart.model.product_category.Basic;
import shopping.cart.model.product_category.Book;
import shopping.cart.model.product_category.Category;
import shopping.cart.model.product_category.FoodBeverage;

@Service
public class ProductCategoryFactory {

    public Category detectCategoryFrom(String nameProduct) {

        if (isFood(nameProduct))
            return new FoodBeverage();

        if (isBook(nameProduct))
            return new Book();

        return new Basic();
    }

    private boolean isFood(String nameProduct) {
        if (nameProduct.contains(ConstantsString.BEER) || nameProduct.contains( ConstantsString.CAKE ) || nameProduct.contains( ConstantsString.COKE )  || nameProduct.contains( ConstantsString.WINE))
            return true;
        else
            return false;
    }

    private boolean isBook(String nameProduct) {
        if (nameProduct.contains(ConstantsString.BOOK))
            return true;
        else
            return false;
    }
}
