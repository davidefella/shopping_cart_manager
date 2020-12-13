package shopping.cart.model.product_category;

import shopping.cart.ProductsUtils.ConstantsString;

public class Basic implements Category {
    private final int TAXE_PERCENTAGE = 22;
    private final String category = ConstantsString.BASIC; 

    @Override
    public int getPercentage() {
        
        return TAXE_PERCENTAGE; 
    }

    @Override
    public String getCategory() {

        return category;
    }

    
}