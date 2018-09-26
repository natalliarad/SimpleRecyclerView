package com.example.natallia_radaman.simplerecyclerview;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class ContentDataView implements DataView {

    private final String title;
    private final String content;
    private final int type;
    private static int numberOfClicks;
    private boolean isClicked;

    public static final Parcelable.Creator<ContentDataView> CREATOR = new Creator<ContentDataView>() {

        @Override
        public ContentDataView createFromParcel(final Parcel parcel) {
            return new ContentDataView(parcel.readString(), parcel.readString());
        }

        @Override
        public ContentDataView[] newArray(final int i) {
            return new ContentDataView[i];
        }
    };

    ContentDataView(@NonNull final String title,
                    @NonNull final String content) {
        this.title = title;
        this.content = content;
        this.type = DataTypeConstants.CONTENT_DATA_TYPE;
    }

    public static int getNumberOfClicks() {
        return numberOfClicks;
    }

    public String getTitle() {
        return title;
    }

    public static void setNumberOfClicks(final int numberOfClicks) {
        ContentDataView.numberOfClicks = numberOfClicks;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked(final boolean clicked) {
        isClicked = clicked;
    }

    @Override
    public int getItemViewType() {
        return type;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder) {
        final ArticlesRecyclerAdapter.ContentViewHolder contentViewHolder = (ArticlesRecyclerAdapter.ContentViewHolder) viewHolder;
        contentViewHolder.textViewTitle.setText(title);
        contentViewHolder.textViewContent.setText(content);

        if (isClicked()) {
            contentViewHolder.arrowView.setVisibility(View.VISIBLE);
        } else {
            contentViewHolder.arrowView.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel parcel, final int i) {
        parcel.writeString(title);
        parcel.writeString(content);
    }
}
