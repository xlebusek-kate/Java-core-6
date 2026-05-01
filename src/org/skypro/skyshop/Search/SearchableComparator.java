package org.skypro.skyshop.Search;

import java.util.Comparator;


public class SearchableComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable o1, Searchable o2) {
        int lengthComparison = Integer.compare(o2.getSearchTerms().length(), o1.getSearchTerms().length());
        if (lengthComparison != 0) {
            return lengthComparison;
        }
        return o1.getSearchTerms().compareTo(o2.getSearchTerms());
    }
}

