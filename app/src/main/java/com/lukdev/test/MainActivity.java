package com.lukdev.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.lukdev.test.activity.FullScreenActivity;
import com.lukdev.test.adapter.GiphyAdapter;
import com.lukdev.test.adapter.GiphyLoadStateAdapter;
import com.lukdev.test.adapter.OnGiphyClick;
import com.lukdev.test.databinding.ActivityMainBinding;
import com.lukdev.test.ui.GridSpace;
import com.lukdev.test.viewmodel.MainActivityViewModel;
import com.lukdev.test.viewmodel.SearchViewModel;

public class MainActivity extends AppCompatActivity implements OnGiphyClick {
    ActivityMainBinding binding;
    private GiphyAdapter adapter;
    String mQuery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initMain();
    }

    private void initMain(){
        adapter = new GiphyAdapter(this::onGiphyClick);
        MainActivityViewModel viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        viewModel.pagingDataFlowable.subscribe(pagingData -> {
            adapter.submitData(getLifecycle(), pagingData);
        });

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        binding.recyclerView.setLayoutManager(gridLayoutManager);
        binding.recyclerView.addItemDecoration(new GridSpace(2, 20, true));
        binding.recyclerView.setAdapter(
                adapter.withLoadStateFooter(
                        new GiphyLoadStateAdapter(v -> {
                            adapter.retry();
                        })));
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return adapter.getItemViewType(position) == adapter.LOADING_ITEM ? 1 : 2;
            }
        });
    }

    ViewModelProvider.Factory factory = new ViewModelProvider.Factory() {
        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new SearchViewModel(getApplication(), mQuery);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_action, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                mQuery = s;
                if (s != null){
                    binding.recyclerView.scrollToPosition(0);
                    SearchViewModel viewModel = new ViewModelProvider(MainActivity.this, factory).get(s ,SearchViewModel.class);
                    viewModel.pagingDataFlowable.subscribe(pagingData -> {
                        adapter.submitData(getLifecycle(), pagingData);
                    });
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return true;
    }

    @Override
    public void onGiphyClick(int position) {
        String url = adapter.getSelected(position).images.original.url;
        Intent intent = new Intent(MainActivity.this, FullScreenActivity.class);
        intent.putExtra("urlGif", url);
        startActivity(intent);
    }
}