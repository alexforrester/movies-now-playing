package com.digian.movies;

import android.graphics.Movie;

import java.util.List;

/**
 * Created by alexforrester on 15/09/2017.
 */

public interface MovieRepository {
    Movie getMovie(int id);
    List<Movie> getMoviesPlayingNow();
}
