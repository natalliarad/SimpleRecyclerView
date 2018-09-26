package com.example.natallia_radaman.simplerecyclerview;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * An activity representing a list of Articles.
 */
public class MainActivity extends AppCompatActivity implements ArticlesRecyclerAdapter.ClickListenerToActivityCallback {

    private static final String KEY_RECYCLER_VIEW = "recyclerView";
    private List<DataView> articles;

    @SuppressWarnings("ConstantConditions")
    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        if (savedInstanceState == null || !savedInstanceState.containsKey(KEY_RECYCLER_VIEW)) {
            articles = ContentGenerator.generateContentForViews();
        } else {
            articles = savedInstanceState.getParcelableArrayList(KEY_RECYCLER_VIEW);
        }

        final ArticlesRecyclerAdapter adapter = new ArticlesRecyclerAdapter(articles, this);

        final RecyclerView recyclerView = findViewById(R.id.article_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onSaveInstanceState(final Bundle outState) {

        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(KEY_RECYCLER_VIEW, (ArrayList<? extends Parcelable>) articles);
    }

    @Override
    public void onCardClickListenerPositionClicked(final int position) {
        Toast.makeText(this, "You clicked on the element № " + (position - 1) + ". ", Toast.LENGTH_SHORT).show();
    }
}
