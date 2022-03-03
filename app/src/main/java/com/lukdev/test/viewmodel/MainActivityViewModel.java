package com.lukdev.test.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.rxjava3.PagingRx;

import com.lukdev.test.model.GiphyTrending;
import com.lukdev.test.datasource.GiphyData;

import io.reactivex.rxjava3.core.Flowable;
import kotlinx.coroutines.CoroutineScope;

public class MainActivityViewModel extends ViewModel {

    public Flowable<PagingData<GiphyTrending.Datum>> pagingDataFlowable;

    public MainActivityViewModel(){
        init();
    }

    private void init(){
        GiphyData giphyDataSource = new GiphyData();

        Pager<Integer, GiphyTrending.Datum> pager = new Pager(
                new PagingConfig(
                        25,
                        25,
                        false,
                        25),
                () -> giphyDataSource);

        pagingDataFlowable = PagingRx.getFlowable(pager);
        CoroutineScope coroutineScope = ViewModelKt.getViewModelScope(this);
        PagingRx.cachedIn(pagingDataFlowable, coroutineScope);
    }
}
