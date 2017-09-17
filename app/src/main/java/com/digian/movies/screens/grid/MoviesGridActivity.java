package com.digian.movies.screens.grid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.GridView;
import android.widget.Toast;

import com.digian.movies.MoviesApp;
import com.digian.movies.R;
import com.digian.movies.model.MovieGridImage;

import java.util.List;

import javax.inject.Inject;

public class MoviesGridActivity extends AppCompatActivity implements MoviesGridContract.View {

    private static final String TAG = MoviesGridActivity.class.getSimpleName();

    @Inject
    MoviesGridPresenter moviesGridPresenter;

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"(Bundle savedInstanceState)");

        setContentView(R.layout.activity_main);

        ((MoviesApp) getApplication()).createMoviesGridComponent().inject(this);
        moviesGridPresenter.setView(this);

        gridView = findViewById(R.id.gridview);
        gridView.setOnItemClickListener((parent, v, position, id) -> {

        });

        moviesGridPresenter.getMoviesPlayingNow(0);

    }

    @Override
    public void loadMovies(List<MovieGridImage> movieImages) {
        Log.d(TAG,"loadMovies(List<MovieGridImage> movieImages)");
        gridView.setAdapter(new MoviesImageAdapter(this, movieImages));

    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, getString(R.string.report_error, error), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy()");
        ((MoviesApp) getApplication()).releaseMoviesGridComponent();
    }
}
