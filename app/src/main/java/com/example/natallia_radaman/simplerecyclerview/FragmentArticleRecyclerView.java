package com.example.natallia_radaman.simplerecyclerview;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.natallia_radaman.simplerecyclerview.HardCodeContent.HardCodeArticle;
import com.example.natallia_radaman.simplerecyclerview.HardCodeContent.HardCodeContent;

import java.util.List;

/**
 * A fragment representing a list of Articles. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link FragmentArticleDetail} representing
 * item details. Host activity is a {@link MainActivity}
 */
public class FragmentArticleRecyclerView extends Fragment {

    private List<HardCodeArticle> articleList;
    private RecyclerView articlesRecyclerView;
    private ArticlesRecyclerAdapter articlesRecyclerAdapter;
    FragmentCoordinator callbackActivity;

    public static FragmentArticleRecyclerView newInstance() {
        FragmentArticleRecyclerView fragmentArticleRecyclerView = new FragmentArticleRecyclerView();
        return fragmentArticleRecyclerView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callbackActivity = (FragmentCoordinator) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_article_recycler, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        articleList = HardCodeContent.getWorkContentInstance().getArticlesList();
        articlesRecyclerAdapter = new ArticlesRecyclerAdapter(articleList, getContext());
        if (articleList.size() == 0) {
            Toast.makeText(getActivity().getApplicationContext(), "Sorry, there are no elements.",
                    Toast.LENGTH_LONG).show();
        }
        articlesRecyclerView = view.findViewById(R.id.article_recycler_view);
        articlesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        articlesRecyclerView.setAdapter(articlesRecyclerAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        articlesRecyclerAdapter.notifyDataSetChanged();
    }
}
