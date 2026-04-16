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

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();

        Product ball = new FixPriceProduct("Мяч");
        Product coat = new DiscountedProduct("Пальто", 40, 90);
        Product sword = new DiscountedProduct("Меч", 100, 10);
        Product lock = new SimpleProduct("Замок", 60);

        Article chocolateArtc = new Article("Вкусный чоколад", "Ну просто обьеденье");
        Article ballArtc = new Article("Мяч", "Упругий мячик");
        Article swordArtc = new Article("Меч", "Острый как бритва меч");
        try {
            Product chocolate = new DiscountedProduct("Шоколад", -1, 101);
            System.out.println("Всё норм");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при добавлении товара");
        }
        SearchEngine searchEngine = new SearchEngine(10);

        searchEngine.add(ball);
        searchEngine.add(coat);
        searchEngine.add(sword);
        searchEngine.add(lock);

        searchEngine.add(chocolateArtc);
        searchEngine.add(ballArtc);
        searchEngine.add(swordArtc);

        try {
            Searchable found = searchEngine.findSearchable("Мяч");
            System.out.println("Найден объект: " + found.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            Searchable found = searchEngine.findSearchable("gisdgfiosagj");
            System.out.println("Найден объект: " + found.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}