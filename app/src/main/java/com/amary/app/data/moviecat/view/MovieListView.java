package com.amary.app.data.moviecat.view;

import com.amary.app.data.moviecat.model.DisMovieResponse;

public interface MovieListView {
    void showLoading();
    void hideLoading();
    void setMovieList(DisMovieResponse movieList);
    void onErrorLoading(String message);
    void onErrorData();
}
