package com.lukdev.test.request;

import static com.lukdev.test.utils.Credentials.URL_GIPHY;

import com.lukdev.test.model.GiphyTrending;
import com.lukdev.test.utils.Credentials;

import io.reactivex.rxjava3.core.Single;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class GiphyTrendingRequest {

    static APIInterface apiInterface;

    public static APIInterface getAPIInterface() {
        if (apiInterface == null) {

            OkHttpClient.Builder client = new OkHttpClient.Builder();

            client.addInterceptor(chain -> {
                Request original = chain.request();
                HttpUrl originalHttpUrl = original.url();
                HttpUrl url = originalHttpUrl.newBuilder()
                        .addQueryParameter("api_key", Credentials.API_TOKEN)
                        .build();

                Request.Builder requestBuilder = original.newBuilder()
                        .url(url);

                Request request = requestBuilder.build();
                return chain.proceed(request);
            });

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(URL_GIPHY)
                    .client(client.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build();

            apiInterface = retrofit.create(APIInterface.class);
        }
        return apiInterface;
    }

    public interface APIInterface {
        @GET("trending")
        Single<com.lukdev.test.model.GiphyTrending> getCategoryGif(
                @Query("limit") Integer limitSize,
                @Query("offset") Integer offsetSize,
                @Query("rating") String rating,
                @Query("lang") String lang
        );

        @GET("search")
        Single<com.lukdev.test.model.GiphyTrending> getSearchGif(
                @Query("q") String query,
                @Query("limit") Integer limitSize,
                @Query("offset") Integer offsetSize,
                @Query("rating") String rating,
                @Query("lang") String lang
        );
    }
}
