package com.example.natallia_radaman.simplerecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

class ArticlesRecyclerAdapter extends RecyclerView.Adapter {

    private final List<DataView> listOfData;
    private ArticlesRecyclerViewOnItemClickListener articlesRecyclerViewOnItemClickListener;

    ArticlesRecyclerAdapter(final List<DataView> listOfData) {
        this.listOfData = Collections.unmodifiableList(listOfData);
    }

    @Override
    public int getItemViewType(final int position) {
        return listOfData.get(position).getItemViewType();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent,
                                                      final int viewType) {
        switch (viewType) {
            case DataTypeConstants.AUTHOR_DATA_TYPE:
                final View authorTypeView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_type_author, parent, false);

                return new AuthorViewHolder(authorTypeView);

            case DataTypeConstants.CONTENT_DATA_TYPE:
                final View textTypeView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_type_content, parent, false);
                final ContentViewHolder holder = new ContentViewHolder(textTypeView);

                holder.textViewTitle.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(final View view) {
                        final int adapterPosition = holder.getAdapterPosition();
                        if (adapterPosition != RecyclerView.NO_POSITION) {
                            articlesRecyclerViewOnItemClickListener.onItemContentClick(adapterPosition);
                        }
                    }
                });

                holder.textViewContent.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(final View view) {
                        final int adapterPosition = holder.getAdapterPosition();
                        if (adapterPosition != RecyclerView.NO_POSITION) {
                            articlesRecyclerViewOnItemClickListener.onItemContentClick(adapterPosition);
                        }
                    }
                });

                holder.arrowView.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(final View view) {
                        final int adapterPosition = holder.getAdapterPosition();
                        if (adapterPosition != RecyclerView.NO_POSITION) {
                            articlesRecyclerViewOnItemClickListener.onItemImageClick(adapterPosition);
                        }
                    }
                });

                return holder;

            default:
                return new ContentViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_type_content, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        listOfData.get(position).onBindViewHolder(holder);
    }

    @Override
    public int getItemCount() {
        return listOfData.size();
    }

    void setArticlesRecyclerViewOnItemClickListener(final ArticlesRecyclerViewOnItemClickListener listener) {
        articlesRecyclerViewOnItemClickListener = listener;
    }

    public static class AuthorViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewSurname;

        AuthorViewHolder(final View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.text_view_author_name);
            textViewSurname = itemView.findViewById(R.id.text_view_author_surname);
        }
    }

    public static class ContentViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle;
        TextView textViewContent;
        ImageView arrowView;

        ContentViewHolder(final View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.text_view_content_title);
            textViewContent = itemView.findViewById(R.id.text_view_content_text);
            arrowView = itemView.findViewById(R.id.image_view_arrow);
        }

    }

    interface ArticlesRecyclerViewOnItemClickListener {

        void onItemContentClick(int position);

        void onItemImageClick(int position);
    }
}
