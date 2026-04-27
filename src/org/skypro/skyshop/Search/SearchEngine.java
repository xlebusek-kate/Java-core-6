package org.skypro.skyshop.Search;

import java.util.*;

public class SearchEngine {
    private final Map<String, List<Searchable>> fullProductBasket = new LinkedHashMap<>();
    private final List<Searchable> searchables = new LinkedList<>();

    public List<Searchable> search(String query) {
        List<Searchable> objects = new LinkedList<>();
        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getSearchTerms().contains(query)) {
                objects.add(searchable);
            }
        }
        return objects;
    }

    public Map<String, List<Searchable>> findSearchable(String search) throws BestResultNotFound {
        Map<String, List<Searchable>> hashMap = new TreeMap<>();
        if (search == null || search.isEmpty()) {
            throw new BestResultNotFound("Error in search");
        }
        if (!fullProductBasket.isEmpty()) {
            for (String key : fullProductBasket.keySet()) {
                if (key.contains(search)) {
                    List<Searchable> products = fullProductBasket.get(key);
                    if (products != null) {
                        hashMap.put(key,products);
                    }
                }
            }
        }
        return  hashMap;
    }

    public void add(String key, Searchable item) {
        fullProductBasket.computeIfAbsent(key, k -> new LinkedList<>()).add(item);
    }
}