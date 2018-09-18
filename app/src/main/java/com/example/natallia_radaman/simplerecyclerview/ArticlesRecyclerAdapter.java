package com.example.natallia_radaman.simplerecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

class ArticlesRecyclerAdapter extends RecyclerView.Adapter<ArticlesRecyclerAdapter.RecyclerViewHolder> {

    private final String[] articlesTitles;
    private RecyclerViewOnItemClickListener recyclerViewOnItemClickListener;

    ArticlesRecyclerAdapter(final String[] articlesTitles) {
        this.articlesTitles = articlesTitles.clone();
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull final ViewGroup parent,
                                                 final int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.aritcle_item_view, parent, false);
        final RecyclerView.ViewHolder holder = new RecyclerViewHolder(view);

        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View view) {
                final int adapterPosition = holder.getAdapterPosition();
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    recyclerViewOnItemClickListener.onItemClick(articlesTitles[adapterPosition]);
                }
            }
        });

        return (RecyclerViewHolder) holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewHolder holder,
                                 final int position) {
        holder.textView.setText(articlesTitles[holder.getAdapterPosition()]);
    }

    @Override
    public int getItemCount() {
        return articlesTitles.length;
    }

    void setRecyclerViewOnItemClickListener(final RecyclerViewOnItemClickListener listener) {
        recyclerViewOnItemClickListener = listener;
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView;

        RecyclerViewHolder(final View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.article_title_item);
        }
    }

    interface RecyclerViewOnItemClickListener {

        void onItemClick(String item);
    }
}
