package com.lukdev.test.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;


import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;

import com.lukdev.test.adapter.GiphyAdapter;
import com.lukdev.test.adapter.GiphyLoadStateAdapter;
import com.lukdev.test.adapter.OnGiphyClick;
import com.lukdev.test.databinding.ActivitySearchBinding;
import com.lukdev.test.ui.GridSpace;
import com.lukdev.test.viewmodel.SearchViewModel;

public class SearchActivity extends AppCompatActivity implements OnGiphyClick {

    ActivitySearchBinding binding;
    GiphyAdapter adapter;
    String mQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        handleIntent(getIntent());
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(mQuery);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())){
            mQuery = intent.getStringExtra(SearchManager.QUERY);
            initSearch();
        }
    }

    ViewModelProvider.Factory factory = new ViewModelProvider.Factory() {
        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new SearchViewModel(getApplication(), mQuery);
        }
    };

    private void initSearch(){
        adapter = new GiphyAdapter(this);
        SearchViewModel viewModel = new ViewModelProvider(SearchActivity.this, factory).get(SearchViewModel.class);
        viewModel.pagingDataFlowable.subscribe(pagingData -> adapter.submitData(getLifecycle(), pagingData));

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        binding.recyclerViewSearch.setLayoutManager(gridLayoutManager);
        binding.recyclerViewSearch.addItemDecoration(new GridSpace(2, 20, true));
        binding.recyclerViewSearch.setAdapter(
                adapter.withLoadStateFooter(
                        new GiphyLoadStateAdapter(v -> adapter.retry())));
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return adapter.getItemViewType(position) == GiphyAdapter.LOADING_ITEM ? 1 : 2;
            }
        });
    }

    @Override
    public void onGiphyClick(int position) {
        String url = adapter.getSelected(position).images.original.url;
        String title = adapter.getSelected(position).title;
        Intent intent = new Intent(SearchActivity.this, FullScreenActivity.class);
        intent.putExtra("urlGif", url);
        intent.putExtra("nameGif", title);
        startActivity(intent);
    }
}