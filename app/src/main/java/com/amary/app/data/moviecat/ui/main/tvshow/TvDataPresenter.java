package com.amary.app.data.moviecat.ui.main.tvshow;

import com.amary.app.data.moviecat.data.networking.Api;
import com.amary.app.data.moviecat.data.networking.ApiClient;
import com.amary.app.data.moviecat.data.networking.ApiServer;
import com.amary.app.data.moviecat.data.networking.model.DisTvResponse;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class TvDataPresenter {
    private Api service = ApiClient.getRetrofit().create(Api.class);

    void getTvList(String bahasa, final TvShowView tvShowView){
        tvShowView.showLoading();
        service.getDisTv(ApiServer.API_KEY,bahasa)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DisTvResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DisTvResponse disTvResponse) {
                        tvShowView.setTvList(disTvResponse);
                    }

                    @Override
                    public void onError(Throwable e) {
                        tvShowView.onErrorLoading(e.getLocalizedMessage());
                        tvShowView.onErrorData();
                    }

                    @Override
                    public void onComplete() {
                        tvShowView.hideLoading();
                    }
                });
    }

    void getSearchTv(String bahasa, String value, final TvShowView tvShowView){
        tvShowView.showLoading();
        service.getSearchTv(ApiServer.API_KEY, bahasa, value)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DisTvResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DisTvResponse disTvResponse) {
                        tvShowView.setSearchTv(disTvResponse);
                    }

                    @Override
                    public void onError(Throwable e) {
                        tvShowView.onErrorLoading(e.getLocalizedMessage());
                        tvShowView.onErrorData();
                    }

                    @Override
                    public void onComplete() {
                        tvShowView.hideLoading();
                    }
                });
    }
}
