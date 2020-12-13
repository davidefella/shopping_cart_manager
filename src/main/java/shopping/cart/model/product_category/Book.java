package shopping.cart.model.product_category;

import shopping.cart.ProductsUtils.ConstantsString;

public class Book implements Category {
    private final int TAXE_PERCENTAGE = 10;
    private final String category =  ConstantsString.BOOK;  

    @Override
    public int getPercentage() {

        return TAXE_PERCENTAGE;
    }

    @Override
    public String getCategory() {
        return category;
    }
}