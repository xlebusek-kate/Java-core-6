package org.skypro.skyshop.Search;

import java.util.*;

public class SearchEngine {
    private final Map<String, Set<Searchable>> fullProductBasket = new LinkedHashMap<>();
    private final Set<Searchable> searchables = new HashSet<>();

    public Set<Searchable> search(String query) {
        Set<Searchable> objects = new HashSet<>();
        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getSearchTerms().contains(query)) {
                objects.add(searchable);
            }
        }
        return objects;
    }

    public TreeSet<Searchable> findSearchable(String search) throws BestResultNotFound {
        TreeSet<Searchable> hashMap = new TreeSet<>(new SearchableComparator());
        if (search == null || search.isEmpty()) {
            throw new BestResultNotFound("Error in search");
        }
        if (!fullProductBasket.isEmpty()) {
            for (String key : fullProductBasket.keySet()) {
                if (key.contains(search)) {
                    if (fullProductBasket.get(key) != null) {
                        hashMap.addAll(fullProductBasket.get(key));
                    }
                }
            }
        }
        return hashMap;
    }

    public void add(String key, Searchable item) {
        fullProductBasket.computeIfAbsent(key, k -> new HashSet<>()).add(item);
    }


}