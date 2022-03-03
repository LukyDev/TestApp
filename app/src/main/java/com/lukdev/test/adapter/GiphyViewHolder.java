package com.lukdev.test.adapter;

import android.view.View;

import com.lukdev.test.databinding.GyphiItemListBinding;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GiphyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    GyphiItemListBinding itemListBinding;
    OnGiphyClick onGiphyClick;

    public GiphyViewHolder(@NonNull GyphiItemListBinding itemListBinding, OnGiphyClick onGiphyClick) {
        super(itemListBinding.getRoot());

        this.onGiphyClick = onGiphyClick;
        this.itemListBinding = itemListBinding;
        itemListBinding.getRoot().setOnClickListener(
                this::onClick
        );
    }


    @Override
    public void onClick(View view) {
        onGiphyClick.onGiphyClick(getBindingAdapterPosition());
    }
}
