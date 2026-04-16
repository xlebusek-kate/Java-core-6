package org.skypro.skyshop.product;

import org.skypro.skyshop.Search.Searchable;

    public abstract class Product implements Searchable {
        private final String productName;

        public Product(String productName) {
            if (productName == null) {
                throw new IllegalArgumentException("Product name cannot be null");
            }
            if (productName.isBlank()) {
                throw new IllegalArgumentException("Product name cannot be blank");
            }
            this.productName = productName;
        }

        public String getProductName() {
            return productName;
        }

        public abstract double getPrice();

        public abstract boolean isSpecial();

        @Override
        public String getContentType() {
            return "PRODUCT";
        }

        @Override
        public String getSearchTerms() {
            return productName;
        }

        @Override
        public String toString() {
            return productName + ": " + getPrice();
        }
    }

