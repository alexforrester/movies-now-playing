
package com.digian.movies.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NowPlayingResponse {

    @SerializedName("results")
    private List<MovieGridImage> movieImages = null;
    private int page;
    private int totalPages;

    public List<MovieGridImage> getMovieImages() {
        return movieImages;
    }
}
