package com.example.natallia_radaman.simplerecyclerview;

import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;

public interface DataView extends Parcelable {

    int getItemViewType();

    void onBindViewHolder(RecyclerView.ViewHolder viewHolder);

}
