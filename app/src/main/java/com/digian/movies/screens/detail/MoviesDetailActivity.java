package com.digian.movies.screens.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.digian.movies.Constants;
import com.digian.movies.MoviesApp;
import com.digian.movies.R;
import com.digian.movies.model.Movie;
import com.digian.movies.model.Part;
import com.digian.movies.screens.grid.MoviesGridPresenter;

import java.util.List;

import javax.inject.Inject;

import static com.digian.movies.Constants.THE_MOVIE_DB_MOVIE_DEFAULT_ID;

public class MoviesDetailActivity extends AppCompatActivity implements MoviesDetailContract.View {

    private static final String TAG = MoviesDetailActivity.class.getSimpleName();

    @Inject
    MoviesDetailPresenter moviesDetailPresenter;
    private ImageView imageView;
    private TextView title;
    private TextView description;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        ((MoviesApp) getApplication()).createMoviesDetailComponent().inject(this);
        moviesDetailPresenter.setView(this);

        imageView = findViewById(R.id.mainImage);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        recyclerView = findViewById(R.id.moviecollection);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        int movieId = getIntent().getIntExtra(Constants.THE_MOVIE_DB_MOVIE_ID, THE_MOVIE_DB_MOVIE_DEFAULT_ID);

        moviesDetailPresenter.getMovie(movieId);
    }


    @Override
    public void loadMovie(Movie movie) {
        Log.d(MoviesDetailActivity.class.getSimpleName(), "Load Movie into view");

        title.setText(movie.getTitle());
        description.setText(movie.getOverview());
        //FIXME - Network request is run even if placeholder image is null
        Glide.with(this).load(movie.getImageUrl()).into(imageView);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, getString(R.string.report_error, error), Toast.LENGTH_LONG).show();
    }

    @Override
    public void displayCollection(List<Part> parts) {

        RecyclerViewClickListener listener = (view, position) -> {
            Log.d(TAG, "onClick Collection");
            int movieId = parts.get(position).getId();

            Intent intent = new Intent(this, MoviesDetailActivity.class);
            intent.putExtra(Constants.THE_MOVIE_DB_MOVIE_ID,movieId);
            startActivity(intent);
        };

        MovieCollectionAdapter adapter = new MovieCollectionAdapter(parts,listener);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy()");
        moviesDetailPresenter.setView(null);
        ((MoviesApp) getApplication()).releaseMoviesDetailComponent();
    }

}
