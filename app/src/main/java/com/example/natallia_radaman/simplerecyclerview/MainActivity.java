package com.example.natallia_radaman.simplerecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

/**
 * An activity representing a list of Articles.
 */
public class MainActivity extends AppCompatActivity implements ArticlesRecyclerAdapter.RecyclerViewOnItemClickListener {

    private static final int NUMBER_OF_ARTICLES = 30;

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        makeArticleTitles();

        final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        final ArticlesRecyclerAdapter adapter = new ArticlesRecyclerAdapter(makeArticleTitles());
        adapter.setRecyclerViewOnItemClickListener(this);

        final RecyclerView recyclerView = findViewById(R.id.article_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    private String[] makeArticleTitles() {
        final String[] articleTitles = new String[NUMBER_OF_ARTICLES];

        for (int i = 0; i < NUMBER_OF_ARTICLES; i++) {
            articleTitles[i] = "Article number " + i;
        }

        return articleTitles;
    }

    @Override
    public void onItemClick(final String item) {
        Toast.makeText(this, "You clicked on " + item.toLowerCase() + ".", Toast.LENGTH_SHORT).show();
    }
}
