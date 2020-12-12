package shopping.cart.model.coupon_category;

public class NoCoupon implements Coupon {
    private final int DISCOUNT_PERCENTAGE = 0;

    @Override
    public int getPercentage() {

        return DISCOUNT_PERCENTAGE;
    }
}
