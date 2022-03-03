package com.lukdev.test.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;

import androidx.annotation.NonNull;
import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.DiffUtil;

import com.bumptech.glide.Glide;
import com.lukdev.test.model.GiphyTrending;
import com.lukdev.test.databinding.GyphiItemListBinding;

public class GiphyAdapter extends PagingDataAdapter<GiphyTrending.Datum, GiphyViewHolder> {

    public static final int LOADING_ITEM = 0;
    public static final int GIPHY_ITEM = 1;
    private OnGiphyClick onGiphyClick;

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
        Glide.with(holder.itemView.getContext())
                .asGif()
                .load(item.images.previewGif.url)
                .into(holder.itemListBinding.giphyGif);
        holder.itemListBinding.nameUser.setText(item.username);

    }

    @Override
    public int getItemViewType(int position) {
        return position == getItemCount() ? GIPHY_ITEM : LOADING_ITEM;
    }

    public GiphyTrending.Datum getSelected(int position){
        GiphyTrending.Datum item = getItem(position);
        return item;
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
