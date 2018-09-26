package com.example.natallia_radaman.simplerecyclerview;

import java.util.ArrayList;
import java.util.List;

public final class ContentGenerator {

    private static final int NUMBER_OF_ARTICLES = 30;
    private static final String AUTHOR_NAME = "Natallia";
    private static final String AUTHOR_SURNAME = "Radaman";
    private static final String NUMBER_OF_CLICKS = "The number of clicks is ";

    public static List<DataView> generateContentForViews() {
        final List<DataView> contentList = new ArrayList<>();

        for (int i = 1; i < NUMBER_OF_ARTICLES + 1; i++) {

            if (i == 1) {
                contentList.add(new ClickCountDataViewToHeader(NUMBER_OF_CLICKS));
            } else if (i % 4 == 2) {
                contentList.add(new AuthorDataView(AUTHOR_NAME, AUTHOR_SURNAME));
            } else {
                final StringBuilder builder = new StringBuilder();

                for (int j = 1; j < i + 1; j++) {

                    if (j != i) {
                        builder.append(j).append(", ");
                    } else {
                        builder.append(j).append(".");
                    }
                }

                contentList.add(new ContentDataView("Item № " + (i - 2) + ".", builder.toString()));
            }
        }

        return contentList;
    }
}
