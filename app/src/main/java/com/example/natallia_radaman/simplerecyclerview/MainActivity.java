package com.example.natallia_radaman.simplerecyclerview;

import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * An activity representing a list of Articles {@link FragmentArticleRecyclerView}. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link FragmentArticleDetail} representing
 * item details.
 */
public class MainActivity extends AppCompatActivity implements FragmentCoordinator {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment_container,
                FragmentArticleRecyclerView.newInstance()).commit();
    }

    @Override
    public void onArticleListItemSelected(int position) {
        FragmentArticleDetail fragmentArticleDetail = FragmentArticleDetail.newInstance(position);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            fragmentManager.beginTransaction().replace(R.id.fragment_container, fragmentArticleDetail)
                    .addToBackStack(null).commit();
        }
        //TODO Landscape orientation.
        //if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
    }
}
