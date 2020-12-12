package shopping.cart.model.coupon_category;

public class CouponGift5 implements Coupon {
    private final int DISCOUNT_PERCENTAGE = 5;

    @Override
    public int getPercentage() {

        return DISCOUNT_PERCENTAGE;
    }
}

