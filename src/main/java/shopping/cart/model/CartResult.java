package shopping.cart.model;

import java.util.List;

import shopping.cart.ProductsUtils.RounderDecimal;

public class CartResult {
    String currency;
    String idShoppingCart;
    List<Product> products;
    double totalTaxes;
    double totalAmount;

    public String getIdShoppingCart() {
        return idShoppingCart;
    }

    public void setIdShoppingCart(String idShoppingCart) {
        this.idShoppingCart = idShoppingCart;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getTotalTaxes() {
        return Double.parseDouble(RounderDecimal.formatDecimals2String(totalTaxes));
    }

    public void setTotalTaxes(double totalTaxes) {
        this.totalTaxes = Double.parseDouble(RounderDecimal.formatDecimals2String(totalTaxes));
    }

    public double getTotalAmount() {
        return Double.parseDouble(RounderDecimal.formatDecimals2String(totalAmount));
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = Double.parseDouble(RounderDecimal.formatDecimals2String(totalAmount));
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}