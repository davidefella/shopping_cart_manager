package shopping.cart.model.product_category;

import shopping.cart.ProductsUtils.ConstantsString;

public class FoodBeverage implements Category {
    private final int TAXE_PERCENTAGE = 4;
    private final String category = ConstantsString.FOOD_BEVERAGE; 

    @Override
    public int getPercentage() {

        return TAXE_PERCENTAGE;
    }

    @Override
    public String getCategory() {

        return category;
    }
}