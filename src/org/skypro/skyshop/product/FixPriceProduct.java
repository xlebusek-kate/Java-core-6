package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
        private static final int FIX_PRICE = 100;

        public FixPriceProduct(String productName) {
            super(productName);
        }

        @Override
        public double getPrice() {
            return FIX_PRICE;
        }

        @Override
        public boolean isSpecial() {
            return true;
        }

        @Override
        public String toString() {
            return getProductName() + " с фиксированной ценой: " + getPrice();
        }
    }

