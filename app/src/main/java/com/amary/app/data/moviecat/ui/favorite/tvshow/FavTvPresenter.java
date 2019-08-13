package com.amary.app.data.moviecat.ui.favorite.tvshow;

import com.amary.app.data.moviecat.utils.LocalData;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class FavTvPresenter {

    void getTvLocal(CompositeDisposable compositeDisposable, final FavTvView favTvView){
        favTvView.showLoading();
        compositeDisposable.add(LocalData.tvRepository.getTvItem()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(tvs -> {
                    if (tvs.isEmpty()){
                        favTvView.onErrorData();
                    }else {
                        favTvView.hideLoading();
                        favTvView.setMovieList(tvs);
                    }
                }));
    }
}
