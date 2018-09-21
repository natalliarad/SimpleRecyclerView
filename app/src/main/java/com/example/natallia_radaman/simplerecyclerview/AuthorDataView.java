package com.example.natallia_radaman.simplerecyclerview;

import android.support.v7.widget.RecyclerView;

public class AuthorDataView implements DataView, DataTypeConstants {

    private final String name;
    private final String surname;

    AuthorDataView(final String name, final String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public int getItemViewType() {
        return DataTypeConstants.AUTHOR_DATA_TYPE;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder) {
        final ArticlesRecyclerAdapter.AuthorViewHolder authorViewHolder = (ArticlesRecyclerAdapter.AuthorViewHolder) viewHolder;
        authorViewHolder.textViewName.setText(name);
        authorViewHolder.textViewSurname.setText(surname);
    }
}
