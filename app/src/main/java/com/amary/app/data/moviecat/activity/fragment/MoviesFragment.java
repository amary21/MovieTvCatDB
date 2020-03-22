package com.amary.app.data.moviecat.activity.fragment;



import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.amary.app.data.moviecat.activity.DetailMovieTvActivity;
import com.amary.app.data.moviecat.customclick.ItemClickSupport;
import com.amary.app.data.moviecat.R;
import com.amary.app.data.moviecat.activity.SettingActivity;
import com.amary.app.data.moviecat.adapter.MovieCatGridAdapter;
import com.amary.app.data.moviecat.adapter.MovieCatListAdapter;
import com.amary.app.data.moviecat.model.MovieTvCatData;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {
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
    private ArrayList<MovieTvCatData> movieTvCatData = new ArrayList<>();
    private RecyclerView rvMovies;

    public MoviesFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies, container, false);
        rvMovies = view.findViewById(R.id.rv_movies);
        rvMovies.setHasFixedSize(true);
        setHasOptionsMenu(true);

        showRecyclerListMovies();
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_list_rv, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mn_list:
                showRecyclerListMovies();
                break;
            case R.id.mn_grid:
                showRecyclerGridMovies();
                break;
            case R.id.mn_setting:
                Intent intent = new Intent(getActivity(), SettingActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showRecyclerListMovies(){
        prepareMovies();
        rvMovies.setLayoutManager(new LinearLayoutManager(getActivity()));
        MovieCatListAdapter movieCatListAdapter = new MovieCatListAdapter(getActivity());
        addItem();
        movieCatListAdapter.setMovieTvCatData(movieTvCatData);
        rvMovies.setAdapter(movieCatListAdapter);
        ItemClickSupport.addTo(rvMovies).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                selectedItem(movieTvCatData.get(position));
            }
        });
    }

    private void showRecyclerGridMovies(){
        prepareMovies();
        rvMovies.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        MovieCatGridAdapter movieCatGridAdapter = new MovieCatGridAdapter(getActivity());
        addItem();
        movieCatGridAdapter.setMovieTvCatData(movieTvCatData);
        rvMovies.setAdapter(movieCatGridAdapter);
        ItemClickSupport.addTo(rvMovies).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                selectedItem(movieTvCatData.get(position));
            }
        });
    }

    private void addItem(){
        movieTvCatData = new ArrayList<>();

        for (int i=0; i < dataJudul.length; i++){
            MovieTvCatData movie = new MovieTvCatData();
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
            movieTvCatData.add(movie);
        }
    }

    private void prepareMovies(){
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

    private void selectedItem(MovieTvCatData movie){
        Intent intent = new Intent(getActivity(), DetailMovieTvActivity.class);
        intent.putExtra(DetailMovieTvActivity.EXTRA_MOVIE, movie);
        startActivity(intent);
    }

}
