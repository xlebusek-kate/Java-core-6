package org.skypro.skyshop.basket;

import org.skypro.skyshop.Search.Searchable;
import org.skypro.skyshop.product.Product;

import java.util.*;


public class ProductBasket {
    private List<Product> productBasket = new LinkedList<>();
    private Map<String, List<Product>> fullProductBasket = new LinkedHashMap<>();

    public void add(String name, List<Product> products) {
        fullProductBasket.computeIfAbsent(name, k -> new ArrayList<>()).addAll(products);
    }

    public void printAllInformation() {
        for (String key : fullProductBasket.keySet()) {
            System.out.println("key = " + key + " \nProducts: ");
            List<Product> list = fullProductBasket.get(key);
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
        for (int i = 0; i < productBasket.size(); i++) {

            productBasket.set(i, null);
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


