
package com.digian.movies.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NowPlayingResponse {

    @SerializedName("results")
    private List<MovieGridImage> movieImages = null;
    private int page;
    private int total_pages;

    public int getPage() {
        return page;
    }

    public int getTotalPages() {
        return total_pages;
    }

    public List<MovieGridImage> getMovieImages() {
        return movieImages;
    }
}
