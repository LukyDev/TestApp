package com.lukdev.test.datasource;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.paging.PagingState;
import androidx.paging.rxjava3.RxPagingSource;

import com.lukdev.test.model.GiphyTrending;
import com.lukdev.test.request.GiphyTrendingRequest;
import com.lukdev.test.utils.Credentials;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class GiphySearch  extends RxPagingSource<Integer, GiphyTrending> {

    String mQuery;

    public GiphySearch(String mQuery) {
        this.mQuery = mQuery;
    }

    @NonNull
    @Override
    public Single<LoadResult<Integer, GiphyTrending>> loadSingle(@NonNull LoadParams<Integer> loadParams) {
        int offset = loadParams.getKey() !=null ? loadParams.getKey() : 0;
        try{
            return GiphyTrendingRequest.getAPIInterface()
                    .getSearchGif(
                            mQuery,
                            25,
                            offset,
                            "g",
                            Credentials.LANG
                    )
                    .map(GiphyTrending::getData)
                    .map(giphy -> toLoadResult(giphy, offset))
                    .cache()
                    .observeOn(Schedulers.newThread())
                    .onErrorReturn(LoadResult.Error::new);
        }catch (Exception e){
            return Single.just(new LoadResult.Error(e));
        }

    }

    private LoadResult<Integer, GiphyTrending> toLoadResult(List<GiphyTrending.Datum> giphy, int offset){
        return new LoadResult.Page(giphy, offset == 25 ? null : offset - 25, offset + 25);
    }

    @Nullable
    @Override
    public Integer getRefreshKey(@NonNull PagingState<Integer, GiphyTrending> pagingState) {
        return null;
    }
}
