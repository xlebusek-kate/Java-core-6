package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
        private final Product[] product;

        public ProductBasket() {
            this.product = new Product[5];
        }

        public void addProduct(Product newProduct) {
            for (int i = 0; ; i++) {
                if (i < product.length && product[i] == null) {
                    product[i] = newProduct;
                    break;
                }
                if (i > product.length) {
                    System.out.println("Невозможно добавить продукт");
                    break;
                }
            }
        }

        public void printBasket() {
            int count = 0;
            for (Product productBasket : product) {
                if (productBasket != null) {
                    count++;
                    System.out.println(productBasket);
                }
            }
            if (count == 0) {
                System.out.println("В корзине пусто");
            }
            System.out.println(String.format("Итого: %.2f ", getTotalCost()));
            System.out.println("Специальных товаров: " + isSpecialProduct());
        }

        public double getTotalCost() {
            double price = 0;
            for (double i = 0; i < product.length; i++) {
                if (product[(int) i] != null) {
                    price += product[(int) i].getPrice();
                }
            }
            return price;
        }

        public boolean productExist(String productName) {
            for (Product productBasket : product) {
                if (productBasket != null && productBasket.getProductName().equals(productName)) {
                    System.out.println(true);
                    return true;
                }
            }
            System.out.println(false);
            return false;
        }

        public void removeAllProduct() {
            for (int i = 0; i < product.length; i++) {
                product[i] = null;
            }
        }

        public int isSpecialProduct() {
            int countIsSpec = 0;
            for (Product productIsSpecial : product) {
                if (productIsSpecial != null && productIsSpecial.isSpecial()) {
                    countIsSpec++;
                }
            }
            return countIsSpec;
        }
    }

