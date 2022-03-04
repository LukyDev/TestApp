package com.lukdev.test.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GiphyTrending {

    @SerializedName("data")
    @Expose
    public List<Datum> data = null;

    public List<Datum> getData() {
        return data;
    }


    public static class Datum {

        @SerializedName("id")
        @Expose
        public String id;
        @SerializedName("title")
        @Expose
        public String title;
        @SerializedName("images")
        @Expose
        public Images images;


        public String getId() {
            return id;
        }
    }

    public static class Images {

        @SerializedName("original")
        @Expose
        public Original original;

    }

    public static class Original {
        @SerializedName("url")
        @Expose
        public String url;
        @SerializedName("webp")
        @Expose
        public String webp;
    }


}