
package com.digian.movies.model;

import com.digian.movies.Constants;

public class MovieGridImage extends MovieData {

    public String getImageUrl() {
        return new StringBuilder(Constants.Images.BASE_IMAGE_URL).append(Constants.Images.POSTER_SIZE_GRID_VIEW).append("/").append(poster_path).toString();
    }

}
