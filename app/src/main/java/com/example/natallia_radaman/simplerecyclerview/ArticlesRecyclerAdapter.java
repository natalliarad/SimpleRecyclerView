package com.example.natallia_radaman.simplerecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.List;

class ArticlesRecyclerAdapter extends RecyclerView.Adapter {

    private final List<DataView> listOfData;
    private final ClickListenerToActivityCallback activityCallback;
    private ClickCountListenerToHeaderContentTypeCallback headerCallback;

    ArticlesRecyclerAdapter(@NonNull final List<DataView> listOfData,
                            @NonNull final ClickListenerToActivityCallback activityCallback) {
        this.listOfData = Collections.unmodifiableList(listOfData);
        this.activityCallback = activityCallback;
    }

    @Override
    public int getItemViewType(final int position) {
        return listOfData.get(position).getItemViewType();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent,
                                                      final int viewType) {
        switch (viewType) {
            case DataTypeConstants.AUTHOR_DATA_TYPE:
                final View authorTypeView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_type_author, parent, false);

                return new AuthorViewHolder(authorTypeView);
            case DataTypeConstants.CONTENT_DATA_TYPE:
                final View textTypeView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_type_content, parent, false);
                final ContentViewHolder holder = new ContentViewHolder(textTypeView);

                holder.cardViewContentType.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(final View view) {
                        final int adapterPosition = holder.getAdapterPosition();
                        setClickListeners(adapterPosition, holder.arrowView);
                    }
                });

                return holder;
            case DataTypeConstants.HEADER_DATA_TYPE:
                final View headerTypeView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_type_header, parent, false);
                final HeaderViewHolder headerViewHolder = new HeaderViewHolder(headerTypeView);
                headerCallback = headerViewHolder;

                return headerViewHolder;
            default:
                return new ContentViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_type_content, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        listOfData.get(position).onBindViewHolder(holder);
    }

    @Override
    public int getItemCount() {
        return listOfData.size();
    }

    private void setClickListeners(final int adapterPosition, @NonNull final ImageView arrowView) {
        if (adapterPosition != RecyclerView.NO_POSITION) {
            final ContentDataView contentDataView = (ContentDataView) listOfData.get(adapterPosition);
            final int numberOfClicks = ContentDataView.getNumberOfClicks();

            if (contentDataView.isClicked()) {
                ContentDataView.setNumberOfClicks(numberOfClicks - 1);
                arrowView.setVisibility(View.INVISIBLE);
                contentDataView.setClicked(false);
            } else {
                ContentDataView.setNumberOfClicks(numberOfClicks + 1);
                arrowView.setVisibility(View.VISIBLE);
                contentDataView.setClicked(true);
            }

            activityCallback.onCardClickListenerPositionClicked(adapterPosition);
            headerCallback.onCardClickListenerClicked(ContentDataView.getNumberOfClicks());
        }
    }

    public static class AuthorViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewSurname;

        AuthorViewHolder(final View itemView) {

            super(itemView);
            textViewName = itemView.findViewById(R.id.text_view_author_name);
            textViewSurname = itemView.findViewById(R.id.text_view_author_surname);
        }
    }

    public static class ContentViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle;
        TextView textViewContent;
        ImageView arrowView;
        CardView cardViewContentType;

        ContentViewHolder(final View itemView) {

            super(itemView);
            textViewTitle = itemView.findViewById(R.id.text_view_content_title);
            textViewContent = itemView.findViewById(R.id.text_view_content_text);
            arrowView = itemView.findViewById(R.id.image_view_arrow);
            cardViewContentType = itemView.findViewById(R.id.card_view_content_type);
        }

    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder implements ClickCountListenerToHeaderContentTypeCallback {

        TextView textViewHeader;

        HeaderViewHolder(final View itemView) {

            super(itemView);
            textViewHeader = itemView.findViewById(R.id.text_view_header);
        }

        @Override
        public void onCardClickListenerClicked(final int clicks) {
            this.textViewHeader.setText(MessageFormat.format("{0}{1}", "The number of clicks: ", clicks));
        }
    }

    interface ClickListenerToActivityCallback {

        void onCardClickListenerPositionClicked(final int position);
    }

    private interface ClickCountListenerToHeaderContentTypeCallback {

        void onCardClickListenerClicked(int clicks);
    }
}
