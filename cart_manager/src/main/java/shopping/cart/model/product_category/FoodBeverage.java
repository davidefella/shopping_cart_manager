package shopping.cart.model.product_category;

public class FoodBeverage implements Category {
    private final int TAXE_PERCENTAGE = 4;
    private final String category = "food-beverage"; 

    @Override
    public int getPercentage() {

        return TAXE_PERCENTAGE;
    }

    @Override
    public String getCategory() {

        return category;
    }
}