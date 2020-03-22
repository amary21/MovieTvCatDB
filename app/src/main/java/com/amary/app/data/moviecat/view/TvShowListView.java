package com.amary.app.data.moviecat.view;

import com.amary.app.data.moviecat.model.DisTvResponse;

public interface TvShowListView {
    void showLoading();
    void hideLoading();
    void setTvList(DisTvResponse tvList);
    void onErrorLoading(String message);
    void onErrorData();
}
