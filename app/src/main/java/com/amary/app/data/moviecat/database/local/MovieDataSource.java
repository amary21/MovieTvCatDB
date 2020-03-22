package com.amary.app.data.moviecat.database.local;

import com.amary.app.data.moviecat.database.datasource.IMovieDataSource;
import com.amary.app.data.moviecat.database.model_db.Movie;

import java.util.List;

import io.reactivex.Flowable;

public class MovieDataSource implements IMovieDataSource {

    private MovieDAO movieDAO;
    private static MovieDataSource instance;

    private MovieDataSource(MovieDAO movieDAO) {
        this.movieDAO = movieDAO;
    }

    public static MovieDataSource getInstance(MovieDAO movieDAO){
        if (instance == null)
            instance = new MovieDataSource(movieDAO);
        return instance;
    }

    @Override
    public Flowable<List<Movie>> getMovieItem() {
        return movieDAO.getMovieItem();
    }

    @Override
    public void insertItemMovie(Movie... movies) {
        movieDAO.insertItemMovie(movies);
    }

    @Override
    public void deleteItemMovie(Movie... movies) {
        movieDAO.deleteItemMovie(movies);
    }

    @Override
    public int isMovie(int idMovie) {
        return movieDAO.isMovie(idMovie);
    }
}
