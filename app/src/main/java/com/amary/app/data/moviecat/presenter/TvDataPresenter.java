package com.amary.app.data.moviecat.presenter;

import com.amary.app.data.moviecat.model.DisTvResponse;
import com.amary.app.data.moviecat.networking.Api;
import com.amary.app.data.moviecat.networking.ApiClient;
import com.amary.app.data.moviecat.networking.ApiServer;
import com.amary.app.data.moviecat.view.TvShowListView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class TvDataPresenter {
    private Api service = ApiClient.getRetrofit().create(Api.class);

    public void getTvList(String bahasa, final TvShowListView tvShowListView){
        tvShowListView.showLoading();
        service.getDisTv(ApiServer.API_KEY,bahasa)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DisTvResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DisTvResponse disTvResponse) {
                        tvShowListView.setTvList(disTvResponse);
                    }

                    @Override
                    public void onError(Throwable e) {
                        tvShowListView.onErrorLoading(e.getLocalizedMessage());
                        tvShowListView.onErrorData();
                    }

                    @Override
                    public void onComplete() {
                        tvShowListView.hideLoading();
                    }
                });
    }
}
