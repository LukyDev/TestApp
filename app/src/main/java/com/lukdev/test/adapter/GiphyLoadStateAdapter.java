package com.lukdev.test.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.LoadState;
import androidx.paging.LoadStateAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.lukdev.test.R;
import com.lukdev.test.databinding.LoadStateItemBinding;

public class GiphyLoadStateAdapter extends LoadStateAdapter<GiphyLoadStateAdapter.LoadStateViewHolder> {

    private View.OnClickListener mRetry;

    public GiphyLoadStateAdapter(View.OnClickListener mRetry) {
        this.mRetry = mRetry;
    }

    @Override
    public void onBindViewHolder(@NonNull LoadStateViewHolder loadStateViewHolder, @NonNull LoadState loadState) {
        loadStateViewHolder.bind(loadState);
    }

    @NonNull
    @Override
    public LoadStateViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, @NonNull LoadState loadState) {
        return new LoadStateViewHolder(viewGroup, mRetry);
    }


    class LoadStateViewHolder extends RecyclerView.ViewHolder {
        private ProgressBar mProgressBar;
        private TextView mErrorMsg;
        private Button mRetryButton;

        LoadStateViewHolder(
                @NonNull ViewGroup parent,
                @NonNull View.OnClickListener retryCallback) {
            super(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.load_state_item, parent, false));

            LoadStateItemBinding binding = LoadStateItemBinding.bind(itemView);
            mProgressBar = binding.giphyProgress;
            mErrorMsg = binding.giphyError;
            mRetryButton = binding.giphyButton;
        }

        public void bind(LoadState loadState) {
            if (loadState instanceof LoadState.Error) {
                LoadState.Error loadStateError = (LoadState.Error) loadState;
                mErrorMsg.setText(loadStateError.getError().getLocalizedMessage());
            }
            mProgressBar.setVisibility(loadState instanceof LoadState.Loading
                    ? View.VISIBLE : View.GONE);
            mRetryButton.setVisibility(loadState instanceof LoadState.Error
                    ? View.VISIBLE : View.GONE);
            mErrorMsg.setVisibility(loadState instanceof LoadState.Error
                    ? View.VISIBLE : View.GONE);
        }
    }
}
