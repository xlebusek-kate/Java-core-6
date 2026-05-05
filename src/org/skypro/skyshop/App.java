package org.skypro.skyshop;

import org.skypro.skyshop.Article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.Search.BestResultNotFound;
import org.skypro.skyshop.Search.SearchEngine;
import org.skypro.skyshop.Search.Searchable;

import java.util.*;

public class App {
    public static void main(String[] args) {

        Searchable plain = new FixPriceProduct("Самолет");
        Searchable car = new FixPriceProduct("Машинка");
        Searchable home = new SimpleProduct("Дом", 2500);

        List<Product> productsInList = new LinkedList<>();
//        productsInList.add(plain);
//        productsInList.add(car);
//        productsInList.add(home);

        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add("Toy", plain);
        searchEngine.add("Toy", car);
        searchEngine.add("Toy", home);

        Product plainP = new FixPriceProduct("Самолет");
        Product carP = new FixPriceProduct("Машинка");
        Product homeP = new SimpleProduct("Дом", 2500);
        Set<Product> products = new HashSet<>();
        products.add(plainP);
        products.add(carP);
        products.add(homeP);

        Map<String,Set<Product>> stringListMap = new LinkedHashMap<>();
        stringListMap.put("Toys", products);
        ProductBasket productBasket1 = new ProductBasket();
        productBasket1.add("Toys" ,products);
        productBasket1.printAllInformation();
        System.out.println("==========================");
        productBasket1.deleteSomeProduct("Toys");
        productBasket1.printAllInformation();


//        try {
//            Map<String, List<Searchable>> results = searchEngine.findSearchable("Toys");
//
//            for (Map.Entry<String, List<Searchable>> entry : results.entrySet()) {
//                System.out.println("Category: " + entry.getKey());
//                for (Searchable item : entry.getValue()) {
//                    System.out.println("Item: " + item);
//                }
//            }
//        } catch (BestResultNotFound e) {
//            System.out.println("Error: " + e.getMessage());
//        }


    }
}