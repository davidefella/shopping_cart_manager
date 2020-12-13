package shopping.cart.ProductsUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopping.cart.model.coupon_category.Coupon;
import shopping.cart.model.coupon_category.CouponGift5;

@Service
public class CouponManager {
    final String COUPON_GIFT_5 = "GIFT5";

    @Autowired
    ProductCategoryDetector productCategoryDetector;

    public Coupon getcoupon(String codeCoupon, String nameProduct) {

        if (codeCoupon == null)
            return null; 

        if (codeCoupon.equals(COUPON_GIFT_5) && isDiscountForThisGood(nameProduct))
            return new CouponGift5();

        return null;
    }

    private boolean isDiscountForThisGood(String nameProduct) {
        return productCategoryDetector.detectCategoryFrom(nameProduct).getCategory().equals("book");

    }
}