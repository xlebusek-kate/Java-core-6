package org.skypro.skyshop.basket;

import org.skypro.skyshop.Search.Searchable;
import org.skypro.skyshop.product.Product;

import java.util.*;


public class ProductBasket {
    private Set<Product> productBasket = new HashSet<>();
    private Map<String, Set<Product>> fullProductBasket = new HashMap<>();

    public void add(String name, Set<Product> products) {
        fullProductBasket.computeIfAbsent(name, k -> new HashSet<>()).addAll(products);
    }

    public void printAllInformation() {
        for (String key : fullProductBasket.keySet()) {
            System.out.println("key = " + key + " \nProducts: ");
            Set<Product>list = fullProductBasket.get(key);
            for (Product products : list) {
                System.out.println("\t" + products.getProductName());
            }

        }

        System.out.println(String.format("Итого: %.2f ", getTotalCost()));
        System.out.println("Специальных товаров: " + isSpecialProduct());
    }

    public double getTotalCost() {
        double price = 0;
        for (Product product : productBasket) {
            if (product != null) {
                price += product.getPrice();
            } else break;
        }
        return price;
    }

    public boolean productExist(String productName) {
        for (Product product : productBasket) {
            if (product != null && product.getProductName().equals(productName)) {
                System.out.println(true);
                return true;
            }
        }
        System.out.println(false);
        return false;
    }

    public void removeAllProduct() {
        for (Product product: productBasket){
            fullProductBasket.remove(product);
        }
    }

    public int isSpecialProduct() {
        int countIsSpec = 0;
        for (Product productIsSpecial : productBasket) {
            if (productIsSpecial != null && productIsSpecial.isSpecial()) {
                countIsSpec++;
            }
        }
        return countIsSpec;
    }

    public void deleteSomeProduct(String key) {
        if (key == null) {
            System.out.println("Пусто");
        }
        for (String keyOfFor : fullProductBasket.keySet()) {
            if (Objects.equals(keyOfFor, key)) {
                fullProductBasket.remove(keyOfFor);
            }

        }
    }
}


