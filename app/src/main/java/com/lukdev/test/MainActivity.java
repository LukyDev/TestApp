package com.lukdev.test;

import androidx.appcompat.app.AppCompatActivity;
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
import com.lukdev.test.activity.SearchActivity;
import com.lukdev.test.adapter.GiphyAdapter;
import com.lukdev.test.adapter.GiphyLoadStateAdapter;
import com.lukdev.test.adapter.OnGiphyClick;
import com.lukdev.test.databinding.ActivityMainBinding;
import com.lukdev.test.ui.GridSpace;
import com.lukdev.test.viewmodel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity implements OnGiphyClick {
    ActivityMainBinding binding;
    private GiphyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initMain();
    }

    private void initMain(){
        adapter = new GiphyAdapter(this);
        MainActivityViewModel viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        viewModel.pagingDataFlowable.subscribe(pagingData -> adapter.submitData(getLifecycle(), pagingData));

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        binding.recyclerView.setLayoutManager(gridLayoutManager);
        binding.recyclerView.addItemDecoration(new GridSpace(2, 20, true));
        binding.recyclerView.setAdapter(
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_action, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        ComponentName componentName =
                new ComponentName(getApplicationContext(), SearchActivity.class);
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(componentName)
        );

        return true;
    }

    @Override
    public void onGiphyClick(int position) {
        String url = adapter.getSelected(position).images.original.url;
        String title = adapter.getSelected(position).title;
        Intent intent = new Intent(MainActivity.this, FullScreenActivity.class);
        intent.putExtra("urlGif", url);
        intent.putExtra("nameGif", title);
        startActivity(intent);
    }
}