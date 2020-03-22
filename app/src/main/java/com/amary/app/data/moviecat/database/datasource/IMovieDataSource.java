package com.amary.app.data.moviecat.database.datasource;

import com.amary.app.data.moviecat.database.model_db.Movie;

import java.util.List;

import io.reactivex.Flowable;

public interface IMovieDataSource {
    Flowable<List<Movie>> getMovieItem();
    void insertItemMovie(Movie...movies);
    void deleteItemMovie(Movie...movies);
    int isMovie(int idMovie);
}
