package org.skypro.skyshop.Article;

import org.skypro.skyshop.Search.Searchable;

    public class Article implements Searchable {

        private final String articleTitle;
        private final String text;

        public Article(String articleTitle, String text) {
            this.articleTitle = articleTitle;
            this.text = text;
        }

        @Override
        public String getSearchTerms() {
            return toString();
        }

        @Override
        public String getContentType() {
            return "ARTICLE";
        }

        @Override
        public String toString() {
            return "Название статьи " + articleTitle + '\'' +
                    " Текст статьи: " + text + '\'';
        }
    }

