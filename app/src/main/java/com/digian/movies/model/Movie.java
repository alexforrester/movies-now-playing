package com.digian.movies.model;

import com.digian.movies.Constants;

/**
 * Created by alexforrester on 17/09/2017.
 */

public class Movie extends MovieData {

    private CollectionSummary belongs_to_collection;
    private String title;
    private String overview;

    public String getImageUrl() {
        return new StringBuilder(Constants.Images.BASE_IMAGE_URL).append(Constants.Images.POSTER_SIZE_DETAIL_VIEW).append("/").append(poster_path).toString();
    }

    public CollectionSummary getBelongs_to_collection() {
        return belongs_to_collection;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }
}