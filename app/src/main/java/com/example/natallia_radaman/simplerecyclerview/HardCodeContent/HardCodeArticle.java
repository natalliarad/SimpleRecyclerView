package com.example.natallia_radaman.simplerecyclerview.HardCodeContent;

public class HardCodeArticle {

    private String articleTitle;
    private String articleContent;

    public HardCodeArticle(String articleTitle) {
        this.articleTitle = articleTitle;
        this.articleContent = "";
    }

    public HardCodeArticle(String articleTitle, String articleContent) {
        this.articleTitle = articleTitle;
        this.articleContent = articleContent;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }
}
