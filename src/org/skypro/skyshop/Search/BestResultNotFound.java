package org.skypro.skyshop.Search;

public class BestResultNotFound extends Exception {
    public BestResultNotFound(String search) {
        super("No results found for " + search);

    }
}
