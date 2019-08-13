package com.amary.app.data.moviecat.ui.favorite.tvshow;

import com.amary.app.data.moviecat.data.database.model_db.Tv;

import java.util.List;

public interface FavTvView {
    void showLoading();
    void hideLoading();
    void setMovieList(List<Tv> tvs);
    void onErrorData();
}
