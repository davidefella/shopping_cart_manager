package shopping.cart.model.product_category;

public class Basic implements Category {
    private final int TAXE_PERCENTAGE = 22;

    @Override
    public int getPercentage() {
        
        return TAXE_PERCENTAGE; 
    }
}