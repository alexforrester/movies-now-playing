package com.digian.movies.screens.grid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.digian.movies.Constants;
import com.digian.movies.MoviesApp;
import com.digian.movies.R;
import com.digian.movies.model.MovieGridImage;
import com.digian.movies.model.Pages;
import com.digian.movies.screens.detail.MoviesDetailActivity;

import java.util.List;

import javax.inject.Inject;

public class MoviesGridActivity extends AppCompatActivity implements MoviesGridContract.View {

    private static final String TAG = MoviesGridActivity.class.getSimpleName();

    @Inject
    MoviesGridPresenter moviesGridPresenter;

    GridView gridView;
    Button previousButton;
    Button nextButton;

    MoviesImageAdapter moviesImageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"(Bundle savedInstanceState)");

        setContentView(R.layout.activity_main);

        ((MoviesApp) getApplication()).createMoviesGridComponent().inject(this);
        moviesGridPresenter.setView(this);

        gridView = findViewById(R.id.gridview);
        previousButton = findViewById(R.id.previousButton);
        nextButton = findViewById(R.id.nextButton);

        gridView.setOnItemClickListener((parent, v, position, id) -> {
                int movieId = moviesImageAdapter.getItem(position).getId();

                Intent intent = new Intent(this, MoviesDetailActivity.class);
                intent.putExtra(Constants.THE_MOVIE_DB_MOVIE_ID,movieId);
                startActivity(intent);
        });

        moviesGridPresenter.getMoviesPlayingNow(0);

    }

    @Override
    public void loadMovies(List<MovieGridImage> movieImages) {
        Log.d(TAG,"loadMovies(List<MovieGridImage> movieImages)");
        moviesImageAdapter = new MoviesImageAdapter(this, movieImages);
        gridView.setAdapter(moviesImageAdapter);

    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, getString(R.string.report_error, error), Toast.LENGTH_LONG).show();
    }

    @Override
    public void updateNavigation(Pages pages) {
        Log.d(TAG,"loadMovies(List<MovieGridImage> movieImages)");

        final int currentPage = pages.getPageNo();
        final int totalPages = pages.getTotalPages();

        if (currentPage == Constants.THE_MOVIE_DB_DEFAULT_PAGE_NO) {
            previousButton.setVisibility(View.GONE);
        }
        else {
            previousButton.setVisibility(View.VISIBLE);
            previousButton.setOnClickListener(view -> moviesGridPresenter.getMoviesPlayingNow(currentPage-1));
        }

        if (currentPage == totalPages) {
            nextButton.setVisibility(View.GONE);
        }
        else {
            nextButton.setVisibility(View.VISIBLE);
            nextButton.setOnClickListener(view -> moviesGridPresenter.getMoviesPlayingNow(currentPage+1));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy()");
        ((MoviesApp) getApplication()).releaseMoviesGridComponent();
    }
}
