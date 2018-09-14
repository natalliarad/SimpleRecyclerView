package com.example.natallia_radaman.simplerecyclerview;

import android.support.v7.widget.RecyclerView;

public class ContentDataView implements DataView, DataTypeConstants {

    private final String title;
    private final String content;

    ContentDataView(final String title, final String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public int getItemViewType() {
        return DataTypeConstants.CONTENT_DATA_TYPE;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder) {
        final ArticlesRecyclerAdapter.ContentViewHolder contentViewHolder = (ArticlesRecyclerAdapter.ContentViewHolder) viewHolder;
        contentViewHolder.textViewTitle.setText(title);
        contentViewHolder.textViewContent.setText(content);
    }
}
