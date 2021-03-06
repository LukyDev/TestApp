package com.lukdev.test.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.DiffUtil;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.lukdev.test.model.GiphyTrending;
import com.lukdev.test.databinding.GyphiItemListBinding;

public class GiphyAdapter extends PagingDataAdapter<GiphyTrending.Datum, GiphyViewHolder> {

    public static final int LOADING_ITEM = 0;
    public static final int GIPHY_ITEM = 1;
    private final OnGiphyClick onGiphyClick;

    public GiphyAdapter(OnGiphyClick onGiphyClick) {
        super(DIFF_CALLBACK);
        this.onGiphyClick = onGiphyClick;
    }

    @NonNull
    @Override
    public GiphyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GiphyViewHolder(
                GyphiItemListBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false),
                onGiphyClick
                );

    }

    @Override
    public void onBindViewHolder(@NonNull GiphyViewHolder holder, int position) {
        GiphyTrending.Datum item = getItem(position);
        if (item != null){
            Glide.with(holder.itemView.getContext())
                    .asGif()
                    .load(item.images.original.url)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.itemListBinding.giphyGif);
        }

    }

    @Override
    public int getItemViewType(int position) {
        return position == getItemCount() ? GIPHY_ITEM : LOADING_ITEM;
    }

    public GiphyTrending.Datum getSelected(int position){
        return getItem(position);
    }


    private static final DiffUtil.ItemCallback<GiphyTrending.Datum> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<GiphyTrending.Datum>() {
                @Override
                public boolean areItemsTheSame(@NonNull GiphyTrending.Datum oldItem, @NonNull GiphyTrending.Datum newItem) {
                    return oldItem.getId().equals(newItem.getId());
                }

                @Override
                public boolean areContentsTheSame(@NonNull GiphyTrending.Datum oldItem, @NonNull GiphyTrending.Datum newItem) {
                    return oldItem.getId().equals(newItem.getId());
                }
            };


}
