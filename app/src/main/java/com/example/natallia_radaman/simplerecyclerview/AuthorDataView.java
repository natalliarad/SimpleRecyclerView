package com.example.natallia_radaman.simplerecyclerview;

import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

public class AuthorDataView implements DataView {

    private final String name;
    private final String surname;
    private final int type;

    public static final Creator<AuthorDataView> CREATOR = new Creator<AuthorDataView>() {

        @Override
        public AuthorDataView createFromParcel(final Parcel parcel) {
            return new AuthorDataView(parcel.readString(), parcel.readString());
        }

        @Override
        public AuthorDataView[] newArray(final int i) {
            return new AuthorDataView[i];
        }
    };

    AuthorDataView(@NonNull final String name,
                   @NonNull final String surname) {
        this.name = name;
        this.surname = surname;
        this.type = DataTypeConstants.AUTHOR_DATA_TYPE;
    }

    @Override
    public int getItemViewType() {
        return type;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder) {
        final ArticlesRecyclerAdapter.AuthorViewHolder authorViewHolder = (ArticlesRecyclerAdapter.AuthorViewHolder) viewHolder;
        authorViewHolder.textViewName.setText(name);
        authorViewHolder.textViewSurname.setText(surname);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel parcel, final int i) {
        parcel.writeString(name);
        parcel.writeString(surname);
    }
}
