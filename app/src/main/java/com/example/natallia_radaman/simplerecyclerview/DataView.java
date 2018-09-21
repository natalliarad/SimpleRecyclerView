package com.example.natallia_radaman.simplerecyclerview;

import android.support.v7.widget.RecyclerView;

public interface DataView {

    int getItemViewType();

    void onBindViewHolder(RecyclerView.ViewHolder viewHolder);
}
