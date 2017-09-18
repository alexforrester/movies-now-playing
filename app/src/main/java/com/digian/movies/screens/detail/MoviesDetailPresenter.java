package com.digian.movies.screens.detail;

import android.content.Context;
import android.support.annotation.VisibleForTesting;
import android.util.Log;

import com.digian.movies.MoviesApp;
import com.digian.movies.MoviesRepository;
import com.digian.movies.model.Collection;
import com.digian.movies.model.CollectionSummary;
import com.digian.movies.model.Movie;
import com.digian.movies.model.NowPlayingResponse;
import com.digian.movies.model.Pages;
import com.digian.movies.model.Part;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by alexforrester on 15/09/2017.
 */

public class MoviesDetailPresenter implements MoviesDetailContract.Presenter<MoviesDetailContract.View> {

    private static final String TAG = MoviesDetailPresenter.class.getSimpleName();

    @Inject
    MoviesRepository moviesRepository;

    @VisibleForTesting
    MoviesDetailContract.View view;

    public MoviesDetailPresenter(Context context) {
        Log.d(TAG, "MoviesGridPresenter(Context context)");

        if (context == null) {
            throw new NullPointerException("Context cannot be null");
        }

        injectDependencies((MoviesApp) context);
    }

    void injectDependencies(MoviesApp moviesApp) {
        moviesApp.createMoviesDetailComponent().inject(this);
    }

    @Override
    public void getMovie(int id) {

        moviesRepository.getMovie(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Movie>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe(Disposable d)");
                    }

                    @Override
                    public void onNext(Movie movie) {
                        Log.d(TAG, "onNext(Movie value)");
                        view.loadMovie(movie);
                        getCollectionIfAvailable(movie);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError(Throwable e)");
                        view.showError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete()");
                    }
                });
    }

    private void getCollectionIfAvailable(Movie movie) {
        CollectionSummary collectionSummary = movie.getBelongs_to_collection();
        if (collectionSummary != null) {

            moviesRepository.getMovieCollection(collectionSummary.getId())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<Collection>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            Log.d(TAG, "onSubscribe(Disposable d)");
                        }

                        @Override
                        public void onNext(Collection collection) {
                            Log.d(TAG, "onNext(Collection collection)");
                            view.displayCollection(collection.getParts());
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.d(TAG, "onError(Throwable e)");
                            view.showError(e.getMessage());
                        }

                        @Override
                        public void onComplete() {
                            Log.d(TAG, "onComplete()");
                        }
                    });

        }
    }

    @Override
    public void setView(MoviesDetailContract.View view) {

        if (view == null) {
            throw new NullPointerException("MoviesDetailContract.View cannot be null");
        }

        this.view = view;
    }
}
