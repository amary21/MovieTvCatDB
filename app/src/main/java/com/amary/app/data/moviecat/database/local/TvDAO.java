package com.amary.app.data.moviecat.database.local;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.amary.app.data.moviecat.database.model_db.Tv;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface TvDAO {
    @Query("SELECT * FROM Tv")
    Flowable<List<Tv>> getTvItem();

    @Query("SELECT EXISTS (SELECT 1 FROM Tv WHERE id_tv=:idTv)")
    int isTv(int idTv);

    @Insert
    void insertItemTv(Tv...tvs);

    @Delete
    void deleteItemTv(Tv...tvs);
}
