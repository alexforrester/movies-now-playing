package com.digian.movies.screens.grid;

/**
 * Created by alexforrester on 15/09/2017.
 */

import android.content.Context;
import android.util.Log;

import com.digian.movies.Constants;
import com.digian.movies.MoviesApp;
import com.digian.movies.MoviesRepository;
import com.digian.movies.model.NowPlayingResponse;
import com.digian.movies.model.Pages;

import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MoviesGridPresenter implements MoviesGridContract.Presenter<MoviesGridContract.View> {

    private String TAG = MoviesGridPresenter.class.getSimpleName();

    @Inject
    MoviesRepository moviesRepository;

    MoviesGridContract.View view;

    public MoviesGridPresenter(Context context) {
        Log.d(TAG, "MoviesGridPresenter(Context context)");

        if (context == null) {
            throw new NullPointerException("Context cannot be null");
        }

        injectDependencies((MoviesApp) context);
    }

    void injectDependencies(MoviesApp moviesApp) {
        moviesApp.createMoviesGridComponent().inject(this);
    }

    @Override
    public void getMoviesPlayingNow(int pageNo) {
        Log.d(TAG, "getMoviesPlayingNow(int pageNo)");

        moviesRepository.getMoviesPlayingNow(pageNo)
                .subscribeOn(Schedulers.io())
                .doOnNext(nowPlayingResponse -> {
                    Log.d(TAG,"setting pages and updating navigation");
                    moviesRepository.setPages(nowPlayingResponse.getPage(), nowPlayingResponse.getTotalPages());
                    updateNavigation();
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NowPlayingResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe(Disposable d)");
                    }

                    @Override
                    public void onNext(NowPlayingResponse nowPlayingResponse) {
                        Log.d(TAG, "onNext(NowPlayingResponse nowPlayingResponse)");
                        view.loadMovies(nowPlayingResponse.getMovieImages());
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

    private void updateNavigation() {
        Single.fromCallable(() -> moviesRepository.getPages())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Pages>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "updateNavigation onSubscribe(Disposable d)");
                    }

                    @Override
                    public void onSuccess(Pages pages) {
                        Log.d(TAG, "updateNavigation onSuccess(Pages pages)");
                        view.updateNavigation(pages);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "updateNavigation onError(Throwable e)");
                        view.showError(e.getMessage());
                    }
                });
    }

    @Override
    public void setView(MoviesGridContract.View view) {
        if (view == null) {
            throw new NullPointerException("MoviesGridContract.View cannot be null");
        }

        this.view = view;

    }
}
