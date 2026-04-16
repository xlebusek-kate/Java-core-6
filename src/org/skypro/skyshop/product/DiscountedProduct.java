package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
        private final double basePrice;
        private final int discountedPrice;

        public DiscountedProduct(String productName, double basePrice, int discountedPrice) {
            super(productName);
            if (basePrice <= 0) {
                throw new IllegalArgumentException("price cannot be negative");
            }
            if (discountedPrice < 0) {
                throw new IllegalArgumentException("discounted price cannot be negative");
            }
            if (discountedPrice > 100) {
                throw new IllegalArgumentException("incorrect discounted price cannot be greater than 100");
            }
            this.basePrice = basePrice;
            this.discountedPrice = discountedPrice;
        }

        @Override
        public double getPrice() {
            return basePrice * (1 - discountedPrice / 100.0);
        }

        @Override
        public boolean isSpecial() {
            return true;
        }

        @Override
        public String toString() {
            return String.format("%s со скидкой: %.2f (%d%%)", getProductName(), getPrice(), discountedPrice);
        }
    }

