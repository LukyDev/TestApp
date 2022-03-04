package com.lukdev.test.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.rxjava3.PagingRx;

import com.lukdev.test.datasource.GiphyData;
import com.lukdev.test.datasource.GiphySearch;
import com.lukdev.test.model.GiphyTrending;

import io.reactivex.rxjava3.core.Flowable;
import kotlinx.coroutines.CoroutineScope;

public class SearchViewModel extends ViewModel {
    public Flowable<PagingData<GiphyTrending.Datum>> pagingDataFlowable;

    Application application;
    String mQuery;

    public SearchViewModel(Application application, String mQuery) {
        this.application = application;
        this.mQuery = mQuery;
        init();
    }

    private void init(){
        GiphySearch giphyDataSource = new GiphySearch(mQuery);

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
