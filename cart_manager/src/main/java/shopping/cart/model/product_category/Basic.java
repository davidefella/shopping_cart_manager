package shopping.cart.model.product_category;

public class Basic implements Category {
    private final int TAXE_PERCENTAGE = 22;

    @Override
    public int getCategory() {
        
        return TAXE_PERCENTAGE; 
    }
}