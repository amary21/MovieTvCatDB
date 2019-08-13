package com.amary.app.data.moviecat.ui.main.movie;

import com.amary.app.data.moviecat.data.networking.model.DisMovieResponse;

public interface MovieView {
    void showLoading();
    void hideLoading();
    void setMovieList(DisMovieResponse movieList);
    void setSearchMovie(DisMovieResponse searchMovie);
    void onErrorLoading(String message);
    void onErrorData();
}
