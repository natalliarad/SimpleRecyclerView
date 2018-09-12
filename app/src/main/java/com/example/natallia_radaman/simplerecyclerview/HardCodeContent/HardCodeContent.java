package com.example.natallia_radaman.simplerecyclerview.HardCodeContent;

import java.util.ArrayList;
import java.util.List;

public class HardCodeContent {

    private static HardCodeContent workContentInstance = null;

    private List<HardCodeArticle> articlesList;

    private HardCodeContent() {
        initArticlesList();
    }

    public List<HardCodeArticle> getArticlesList() {
        return articlesList;
    }

    public static HardCodeContent getWorkContentInstance() {
        if (workContentInstance == null) {
            workContentInstance = new HardCodeContent();
            return workContentInstance;
        } else {
            return workContentInstance;
        }
    }

    private void initArticlesList() {
        articlesList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            articlesList.add(new HardCodeArticle("Article number " + i + ".",
                    "Content number " + i));
        }
    }
}

