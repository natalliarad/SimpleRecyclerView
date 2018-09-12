package com.example.natallia_radaman.simplerecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ArticlesViewHolder extends RecyclerView.ViewHolder implements ArticleItemView {

    private final TextView articleTitleTextView;
    private final TextView articleContentTextView;

    public ArticlesViewHolder(View articleItemView) {
        super(articleItemView);
        articleTitleTextView = articleItemView.findViewById(R.id.article_title_item);
        articleContentTextView = articleItemView.findViewById(R.id.article_creation_date_item);
    }

    public TextView getArticleTitle() {
        return articleTitleTextView;
    }

    @Override
    public void setArticleTitle(String title) {
        articleTitleTextView.setText(title);
    }

    @Override
    public void setArticleContent(String content) {
        articleContentTextView.setText(content);
    }
}