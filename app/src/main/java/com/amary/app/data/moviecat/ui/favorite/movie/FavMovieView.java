package com.amary.app.data.moviecat.ui.favorite.movie;

import com.amary.app.data.moviecat.data.database.model_db.Movie;

import java.util.List;

public interface FavMovieView {
    void showLoading();
    void hideLoading();
    void setMovieList(List<Movie> movieList);
    void onErrorData();
}
