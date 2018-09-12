package com.example.natallia_radaman.simplerecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.natallia_radaman.simplerecyclerview.HardCodeContent.HardCodeArticle;

import java.util.List;

public class ArticlesRecyclerAdapter extends RecyclerView.Adapter<ArticlesViewHolder> {

    private List<HardCodeArticle> articleList;
    private Context context;
    private FragmentCoordinator callbackActivity;

    public ArticlesRecyclerAdapter(List<HardCodeArticle> articleList, Context context) {
        this.articleList = articleList;
        this.context = context;
        callbackActivity = (FragmentCoordinator) context;
    }

    @NonNull
    @Override
    public ArticlesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View articleItemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.aritcle_item_view, parent, false);
        return new ArticlesViewHolder(articleItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ArticlesViewHolder holder, int position) {
        holder.setArticleTitle(articleList.get(holder.getAdapterPosition()).getArticleTitle());
        holder.setArticleContent(articleList.get(holder.getAdapterPosition()).getArticleContent());
        holder.getArticleTitle().setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                callbackActivity.onArticleListItemSelected(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        if (articleList != null) {
            return articleList.size();
        }
        return 0;
    }
}
