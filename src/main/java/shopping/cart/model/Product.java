package shopping.cart.model;

import shopping.cart.ProductsUtils.RounderDecimal;

public class Product {

    String name;
    int quantity;
    double price;

    public Product() {
    }

    public Product(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /* Round decimal every time set Price */
    public double getPrice() {
        return Double.parseDouble(RounderDecimal.formatDecimals2String(price));
    }

    public void setPrice(double price) {
        this.price = Double.parseDouble(RounderDecimal.formatDecimals2String(price));
    }
}