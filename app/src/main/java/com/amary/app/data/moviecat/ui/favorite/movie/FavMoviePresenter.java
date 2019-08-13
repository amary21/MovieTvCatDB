package com.amary.app.data.moviecat.ui.favorite.movie;

import com.amary.app.data.moviecat.utils.LocalData;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class FavMoviePresenter {

    void getMovieLocal(CompositeDisposable compositeDisposable, final FavMovieView favMovieView){
        favMovieView.showLoading();
        compositeDisposable.add(LocalData.movieRepository.getMovieItem()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(movies -> {
                    if (movies.isEmpty()){
                        favMovieView.onErrorData();
                    }else {
                        favMovieView.hideLoading();
                        favMovieView.setMovieList(movies);
                    }
                }));
    }
}