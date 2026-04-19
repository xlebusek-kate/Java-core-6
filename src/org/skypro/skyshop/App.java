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

import java.util.LinkedList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        Product plain = new FixPriceProduct("Самолет");
        Product coat = new DiscountedProduct("Пуховик", 40, 90);
        Product map = new DiscountedProduct("Карта", 100, 10);
        Product lock = new SimpleProduct("Замок", 60);

        basket.add(plain);
        basket.add(coat);
        basket.add(map);
        basket.add(lock);
        System.out.println("========================================================");
        basket.printBasket();
        System.out.println("========================================================");
        List<Product> removeBasket = basket.deleteSomeProduct("Самолет");
        if (removeBasket.isEmpty()){
            System.out.println("Пусто");
        }
        for (int i = 0;i < removeBasket.size();i++){
            System.out.println(removeBasket.get(i));
        }
        System.out.println("========================================================");
        basket.printBasket();
        System.out.println("========================================================");
        basket.deleteSomeProduct("Машинка");
        System.out.println("========================================================");
        basket.removeAllProduct();
        basket.printBasket();








    }
}