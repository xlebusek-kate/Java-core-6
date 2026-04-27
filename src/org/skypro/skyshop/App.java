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

        List<Searchable> productsInList = new LinkedList<>();
        productsInList.add(plain);
        productsInList.add(car);
        productsInList.add(home);

        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add("Toy",plain );
        searchEngine.add("Toy",car );
        searchEngine.add("Toy",home );


        try {
            Map<String, List<Searchable>> results = searchEngine.findSearchable("Toys");

            for (Map.Entry<String, List<Searchable>> entry : results.entrySet()) {
                System.out.println("Category: " + entry.getKey());
                for (Searchable item : entry.getValue()) {
                    System.out.println("Item: " + item);
                }
            }
        } catch (BestResultNotFound e) {
            System.out.println("Error: " + e.getMessage());
        }


    }
}