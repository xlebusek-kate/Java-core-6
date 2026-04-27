package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;


public class ProductBasket {
    private final List<Product> productBasket = new LinkedList<>();
    private Map<String, List<Product>> fullProductBasket = new LinkedHashMap<>();

    public void add(Product product) {
        if (product != null) {
            productBasket.add(product);
        }
    }

    public void printAllInformation() {
        for (String key : fullProductBasket.keySet()) {
            List<Product> products = fullProductBasket.get(key);
            if (products != null) {
                System.out.println("Name" + key);
                for (Product productInProductBasket : productBasket) {
                    if (productInProductBasket != null) {
                        System.out.println("Contents" + productInProductBasket);
                    } else {
                        System.out.println("Contents is empty");
                        break;
                    }
                }
            }else {
                System.out.println("Empty");
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

    public List<Product> deleteSomeProduct(String name) {
        List<Product> deleteBasket = new LinkedList<>();
        Iterator<Product> iterator = productBasket.iterator();
        int count = 0;
        if (productBasket.isEmpty()) {
            System.out.println(" Cписок пуст");
        }

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (name != null && Objects.equals(product.getProductName(), name)) {
                deleteBasket.add(product);
                iterator.remove();
            }
        }
        if (deleteBasket.isEmpty()) {
            System.out.println("Такого в списке нет");
        }
        return deleteBasket;
    }
}


