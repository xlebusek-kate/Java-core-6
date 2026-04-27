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
        Map<String, List<Searchable>> treeMap = new TreeMap<>();
        if (search == null || search.isEmpty()) {
            throw new BestResultNotFound("Error in search");
        }
        if (!fullProductBasket.isEmpty()) {
            for (String key : fullProductBasket.keySet()) {
                if (key.contains(search)) {
                    List<Searchable> list = fullProductBasket.get(key);
                    if (list != null) {
                        treeMap.put(key, list);
                    }
                }
            }
        } else {
            throw new BestResultNotFound("Error in fullProductBasket");
        }
        return treeMap;
    }

    public void add(String key, Searchable item) {
        List<Searchable> list = fullProductBasket.get(key);
        if (list == null) {
            list = new LinkedList<>();
            fullProductBasket.put(key, list);
        }
        list.add(item);
    }

//    public int getFreeIndex() {
//        for (int i = 0; i < searchables.size(); i++) {
//            if (searchables.get(i) == null) {
//                return i;
//            }
//        }
//        return 0;
//    }
}