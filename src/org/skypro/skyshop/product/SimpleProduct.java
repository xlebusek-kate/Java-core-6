package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private final int price;
    public SimpleProduct(String productName, int price) {
        super(productName);
        if (price <= 0) {
            throw new IllegalArgumentException("price cannot be negative");
        }
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return getProductName() + ": " + getPrice();
    }
}