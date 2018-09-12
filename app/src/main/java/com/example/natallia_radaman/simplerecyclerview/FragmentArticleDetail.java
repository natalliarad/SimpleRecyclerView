package com.example.natallia_radaman.simplerecyclerview;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.natallia_radaman.simplerecyclerview.HardCodeContent.HardCodeArticle;
import com.example.natallia_radaman.simplerecyclerview.HardCodeContent.HardCodeContent;

import java.util.List;

/**
 * A fragment representing a single Article detail screen.
 * This fragment is contained in a {@link MainActivity}.
 */
public class FragmentArticleDetail extends Fragment {

    private static final String TAG = "FragmentArticleDetail";
    private static final String CURRENT_INDEX = "current_index";

    private TextView articleTitleTextView;
    private TextView articleContentTextView;

    private int currentIndex = 0;
    private List<HardCodeArticle> articles;
    FragmentCoordinator callbackActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callbackActivity = (FragmentCoordinator) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        articles = HardCodeContent.getWorkContentInstance().getArticlesList();
        currentIndex = getArguments().getInt(CURRENT_INDEX);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewSingleArticle = inflater.inflate(R.layout.fragment_article_details, container,
                false);
        if (savedInstanceState != null) {
            currentIndex = savedInstanceState.getInt(CURRENT_INDEX);
        }
        articleTitleTextView = viewSingleArticle.findViewById(R.id.article_title);
        articleTitleTextView.setText(articles.get(currentIndex).getArticleTitle());
        articleContentTextView = viewSingleArticle.findViewById(R.id.article_content);
        articleContentTextView.setText(articles.get(currentIndex).getArticleContent());
        initUI(viewSingleArticle);
        return viewSingleArticle;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(CURRENT_INDEX, currentIndex);
    }

    private void initUI(View view) {

    }

    public static FragmentArticleDetail newInstance(int articlePositionIndex) {
        System.out.println("" + articlePositionIndex);
        FragmentArticleDetail fragmentArticleDetail = new FragmentArticleDetail();
        Bundle args = new Bundle();
        args.putInt(CURRENT_INDEX, articlePositionIndex);
        fragmentArticleDetail.setArguments(args);
        return fragmentArticleDetail;
    }
}
