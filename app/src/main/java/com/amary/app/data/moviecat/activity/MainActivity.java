package com.amary.app.data.moviecat.activity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.amary.app.data.moviecat.R;
import com.amary.app.data.moviecat.adapter.MovieCatAdapter;
import com.amary.app.data.moviecat.model.MovieCatData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TypedArray dataPoster;
    private TypedArray dataScreen1;
    private TypedArray dataScreen2;
    private TypedArray dataScreen3;
    private TypedArray dataScreen4;
    private TypedArray dataScreen5;
    private String[] dataJudul;
    private String[] dataThnRilis;
    private String[] dataTglRilis;
    private String[] dataDurasi;
    private String[] dataGenre;
    private String[] dataDirectors;
    private String[] dataActors;
    private String[] dataSinopsis;
    private MovieCatAdapter adapter;
    private ArrayList<MovieCatData> movieCatData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieCatAdapter(this);
        ListView lvMovieCat = findViewById(R.id.lv_moviecat);
        lvMovieCat.setAdapter(adapter);

        prepare();
        addItem();

        lvMovieCat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailMovieActivity.class);
                intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movieCatData.get(position));
                startActivity(intent);
            }
        });

    }

    private void addItem(){
        movieCatData = new ArrayList<>();

        for (int i=0; i < dataJudul.length; i++){
            MovieCatData movie = new MovieCatData();
            movie.setPoster(dataPoster.getResourceId(i, -1));
            movie.setScreen1(dataScreen1.getResourceId(i,-1));
            movie.setScreen2(dataScreen2.getResourceId(i,-1));
            movie.setScreen3(dataScreen3.getResourceId(i,-1));
            movie.setScreen4(dataScreen4.getResourceId(i,-1));
            movie.setScreen5(dataScreen5.getResourceId(i,-1));
            movie.setJudul(dataJudul[i]);
            movie.setThnRilis(dataThnRilis[i]);
            movie.setTglRilis(dataTglRilis[i]);
            movie.setDurasiMovie(dataDurasi[i]);
            movie.setGenreMovie(dataGenre[i]);
            movie.setDirectors(dataDirectors[i]);
            movie.setActors(dataActors[i]);
            movie.setSinopsis(dataSinopsis[i]);
            movieCatData.add(movie);
        }
        adapter.setMovieCatData(movieCatData);
    }

    private void prepare(){
        dataJudul       = getResources().getStringArray(R.array.judul_data);
        dataThnRilis    = getResources().getStringArray(R.array.thn_rilis_data);
        dataTglRilis    = getResources().getStringArray(R.array.tanggal_rilis_data);
        dataDurasi      = getResources().getStringArray(R.array.durasi_data);
        dataGenre       = getResources().getStringArray(R.array.genre_data);
        dataDirectors   = getResources().getStringArray(R.array.director_data);
        dataActors      = getResources().getStringArray(R.array.actors_data);
        dataSinopsis    = getResources().getStringArray(R.array.sinopsis_data);
        dataPoster      = getResources().obtainTypedArray(R.array.poster_data);
        dataScreen1     = getResources().obtainTypedArray(R.array.screen_1_data);
        dataScreen2     = getResources().obtainTypedArray(R.array.screen_2_data);
        dataScreen3     = getResources().obtainTypedArray(R.array.screen_3_data);
        dataScreen4     = getResources().obtainTypedArray(R.array.screen_4_data);
        dataScreen5     = getResources().obtainTypedArray(R.array.screen_5_data);
    }
}
