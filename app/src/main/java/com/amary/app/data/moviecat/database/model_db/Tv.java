package com.amary.app.data.moviecat.database.model_db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Tv")
public class Tv {
    @PrimaryKey
    @ColumnInfo(name = "id_tv")
    public int idTv;

    @ColumnInfo(name = "title_tv")
    public String titleTv;

    @ColumnInfo(name = "date_tv")
    public String dateTv;

    @ColumnInfo(name = "rate_tv")
    public Double rateTv;

    @ColumnInfo(name = "poster_tv")
    public String posterTv;

    @ColumnInfo(name = "backdrops_tv")
    public String backdropsTv;
}
