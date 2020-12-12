package shopping.cart.model.product_category;

public class Book implements Category {
    private final int TAXE_PERCENTAGE = 10;

    @Override
    public int getCategory() {

        return TAXE_PERCENTAGE;
    }
}