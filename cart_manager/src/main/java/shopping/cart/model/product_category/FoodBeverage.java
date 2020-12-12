package shopping.cart.model.product_category;

public class FoodBeverage implements Category {
    private final int TAXE_PERCENTAGE = 4;

    @Override
    public int getCategory() {
        return TAXE_PERCENTAGE;
    }
}