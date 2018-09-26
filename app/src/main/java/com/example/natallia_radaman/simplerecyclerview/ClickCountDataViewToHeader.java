package com.example.natallia_radaman.simplerecyclerview;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import java.text.MessageFormat;

public class ClickCountDataViewToHeader implements DataView {

    private final String headerText;
    private final int type;

    public static final Parcelable.Creator<ClickCountDataViewToHeader> CREATOR = new Creator<ClickCountDataViewToHeader>() {

        @Override
        public ClickCountDataViewToHeader createFromParcel(final Parcel parcel) {
            return new ClickCountDataViewToHeader(parcel.readString());
        }

        @Override
        public ClickCountDataViewToHeader[] newArray(final int i) {
            return new ClickCountDataViewToHeader[i];
        }
    };

    ClickCountDataViewToHeader(@NonNull final String numberOfClicksText) {
        this.headerText = numberOfClicksText;
        this.type = DataTypeConstants.HEADER_DATA_TYPE;
    }

    @Override
    public int getItemViewType() {
        return type;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder) {
        final ArticlesRecyclerAdapter.HeaderViewHolder headerViewHolder = (ArticlesRecyclerAdapter.HeaderViewHolder) viewHolder;
        headerViewHolder.textViewHeader.setText(MessageFormat.format("{0}{1}", headerText, ContentDataView.getNumberOfClicks()));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel parcel, final int i) {
        parcel.writeString(headerText);
    }
}
