package com.digian.movies.model;

import com.digian.movies.Constants;

/**
 * Created by alexforrester on 17/09/2017.
 */

public abstract class MovieData {

    int id;
    String poster_path;

    public Integer getId() {return id;}

    public abstract String getImageUrl();

}
