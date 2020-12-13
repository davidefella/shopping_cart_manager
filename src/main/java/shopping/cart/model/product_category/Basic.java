package shopping.cart.model.product_category;

public class Basic implements Category {
    private final int TAXE_PERCENTAGE = 22;
    private final String category = "basic"; 

    @Override
    public int getPercentage() {
        
        return TAXE_PERCENTAGE; 
    }

    @Override
    public String getCategory() {

        return category;
    }

    
}