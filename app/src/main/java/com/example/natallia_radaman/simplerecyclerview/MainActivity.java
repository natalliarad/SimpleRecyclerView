package com.example.natallia_radaman.simplerecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

/**
 * An activity representing a list of Articles.
 */
public class MainActivity extends AppCompatActivity implements ArticlesRecyclerAdapter.ArticlesRecyclerViewOnItemClickListener {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final List<DataView> articles = ContentGenerator.generateContentForViews();

        final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        final ArticlesRecyclerAdapter adapter = new ArticlesRecyclerAdapter(articles);
        adapter.setArticlesRecyclerViewOnItemClickListener(this);

        final RecyclerView recyclerView = findViewById(R.id.article_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void onItemContentClick(final int position) {
        Toast.makeText(this, "Item № " + (position + 1) + ".", Toast.LENGTH_LONG).show();
    }

    public void onItemImageClick(final int position) {
        Toast.makeText(this, "The position of the article in the list is "
                + (position + 1) + ".", Toast.LENGTH_LONG).show();
    }
}
