package com.amary.app.data.moviecat.database.local;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.amary.app.data.moviecat.database.model_db.Movie;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface MovieDAO {
    @Query("SELECT * FROM Movie")
    Flowable<List<Movie>> getMovieItem();

    @Query("SELECT EXISTS (SELECT 1 FROM Movie WHERE id_movie=:idMovie)")
    int isMovie(int idMovie);

    @Insert
    void insertItemMovie(Movie...movies);

    @Delete
    void deleteItemMovie(Movie...movies);
}
