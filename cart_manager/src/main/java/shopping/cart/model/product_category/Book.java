package shopping.cart.model.product_category;

public class Book implements Category {
    private final int TAXE_PERCENTAGE = 10;
    private final String category = "book"; 

    @Override
    public int getPercentage() {

        return TAXE_PERCENTAGE;
    }

    @Override
    public String getCategory() {
        return category;
    }
}