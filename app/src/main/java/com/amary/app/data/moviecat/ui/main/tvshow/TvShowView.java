package com.amary.app.data.moviecat.ui.main.tvshow;

import com.amary.app.data.moviecat.data.networking.model.DisTvResponse;

public interface TvShowView {
    void showLoading();

    void hideLoading();

    void setTvList(DisTvResponse tvList);

    void setSearchTv(DisTvResponse searchTv);

    void onErrorLoading(String message);

    void onErrorData();
}
