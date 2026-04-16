package org.skypro.skyshop.Search;

public interface Searchable {

    String getSearchTerms();

    String getContentType();

    default String getStringRepresentation() {
        return getSearchTerms() + " - " + getContentType();
    }
}
