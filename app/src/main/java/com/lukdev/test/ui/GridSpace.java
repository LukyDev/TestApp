package com.lukdev.test.ui;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GridSpace extends RecyclerView.ItemDecoration {
    private int mCount;
    private int mSpace;
    private boolean mEdge;

    public GridSpace(int mCount, int mSpace, boolean mEdge) {
        this.mCount = mCount;
        this.mSpace = mSpace;
        this.mEdge = mEdge;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);
        int column = position % mCount;

        if (mEdge){
            outRect.left = mSpace - column * mSpace / mCount;
            outRect.right = (column+1) * mSpace / mCount;

            if (position < mCount){
                outRect.top = mSpace;
            }
        } else {
            outRect.left = column * mSpace / mCount;
            outRect.right = mSpace - (column+1) * mSpace / mCount;

            if (position >= mCount){
                outRect.top = mSpace;
            }
        }
    }
}
