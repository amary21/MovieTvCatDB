package com.amary.app.data.moviecat.ui.main.movie;

import com.amary.app.data.moviecat.data.networking.Api;
import com.amary.app.data.moviecat.data.networking.ApiClient;
import com.amary.app.data.moviecat.data.networking.ApiServer;
import com.amary.app.data.moviecat.data.networking.model.DisMovieResponse;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MovieDataPresenter {
    private Api service = ApiClient.getRetrofit().create(Api.class);

    void getMovieList(String bahasa, final MovieView movieView){
        movieView.showLoading();
        service.getDisMovie(ApiServer.API_KEY,bahasa)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DisMovieResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DisMovieResponse disMovieResponse) {
                        movieView.setMovieList(disMovieResponse);
                    }

                    @Override
                    public void onError(Throwable e) {
                        movieView.onErrorLoading(e.getLocalizedMessage());
                        movieView.onErrorData();
                    }

                    @Override
                    public void onComplete() {
                        movieView.hideLoading();
                    }
                });
    }

    public void getSearchMovie(String bahasa,String value, final MovieView movieView){
        movieView.showLoading();
        service.getSearchMovie(ApiServer.API_KEY, bahasa, value)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DisMovieResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DisMovieResponse disMovieResponse) {
                        movieView.setSearchMovie(disMovieResponse);
                    }

                    @Override
                    public void onError(Throwable e) {
                        movieView.onErrorLoading(e.getLocalizedMessage());
                        movieView.onErrorData();
                    }

                    @Override
                    public void onComplete() {
                        movieView.hideLoading();
                    }
                });
    }
}
