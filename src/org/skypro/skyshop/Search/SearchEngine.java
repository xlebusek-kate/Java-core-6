package org.skypro.skyshop.Search;

import java.util.LinkedList;
import java.util.List;

public class SearchEngine {

    private List<Searchable> searchables = new LinkedList<>();

    public List search(String query) {
        List<Searchable> objects = new LinkedList<>();
        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getSearchTerms().contains(query)) {
                objects.add(searchable);
            }
        }
        return objects;
    }

    public Searchable findSearchable(String search) throws BestResultNotFound {
        if (search == null || search.isEmpty()) {
            throw new BestResultNotFound(search);
        }
        Searchable bestResult = null;
        int maxOccurrences = 0;
        String target = search.toLowerCase();

        for (Searchable searchable : searchables) {
            if (searchable == null) continue;
            String text = searchable.getSearchTerms().toLowerCase();
            int count = 0;
            int index = 0;

            while ((index = text.indexOf(target, index)) != -1) {
                count++;
                index += target.length();
            }
            if (count > maxOccurrences) {
                maxOccurrences = count;
                bestResult = searchable;
            }
        }
        if (maxOccurrences <= 0) {
            throw new BestResultNotFound(search);
        }
        return bestResult;
    }
    public void add(Searchable searchable) {
        int freeIndex = getFreeIndex();
        if (freeIndex < -1) {
            System.out.println("Невозможно добавить элемент для поиска");
            return;
        }
        searchables.set(freeIndex, searchable);
    }

    public int getFreeIndex() {
        for (int i = 0; i < searchables.size(); i++) {
            if (searchables.get(i) == null) {
                return i;
            }
        }
        return 0;
    }
}