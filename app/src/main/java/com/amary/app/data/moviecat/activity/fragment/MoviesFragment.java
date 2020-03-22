package com.amary.app.data.moviecat.activity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.amary.app.data.moviecat.R;
import com.amary.app.data.moviecat.activity.DetailMovieActivity;
import com.amary.app.data.moviecat.activity.FavoriteActivity;
import com.amary.app.data.moviecat.activity.SettingActivity;
import com.amary.app.data.moviecat.adapter.MovieListAdapter;
import com.amary.app.data.moviecat.base.BaseFragment;
import com.amary.app.data.moviecat.model.DisMovieResponse;
import com.amary.app.data.moviecat.model.ResultMovie;
import com.amary.app.data.moviecat.view.MovieListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends BaseFragment implements MovieListView {
    private ArrayList<ResultMovie> itemMovie = new ArrayList<>();
    private MovieListAdapter movieListAdapter;

    @BindView(R.id.rv_movies)
    RecyclerView rvMovies;
    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;
    @BindView(R.id.tv_error_get)
    TextView tvErrorGet;

    public MoviesFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        String bhsLocal = getString(R.string.localization);
        setHasOptionsMenu(true);

        showData();

        if (savedInstanceState ==null){
            getMovieDataPresenter().getMovieList(bhsLocal, this);
        }else {
            itemMovie = savedInstanceState.getParcelableArrayList(KEY_MOVIES_LIST);
            movieListAdapter.refill(itemMovie);
        }
    }

    private void showData(){
        movieListAdapter = new MovieListAdapter(itemMovie);
        rvMovies.setHasFixedSize(true);
        rvMovies.setLayoutManager(new LinearLayoutManager(getContext()));
        rvMovies.setAdapter(movieListAdapter);
        movieListAdapter.setOnItemClickListener((view, position) -> {
            Intent intent = new Intent(getActivity(), DetailMovieActivity.class);
            intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, itemMovie.get(position));
            startActivity(intent);
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_app_bar, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.mn_app_setting) {
            Intent intent = new Intent(getActivity(), SettingActivity.class);
            startActivity(intent);
        }
        if (item.getItemId() == R.id.mn_app_favorite){
            Intent intent = new Intent(getActivity(), FavoriteActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showLoading() {
        pbLoading.setVisibility(View.VISIBLE);
        rvMovies.setVisibility(View.GONE);
        tvErrorGet.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        pbLoading.setVisibility(View.GONE);
        tvErrorGet.setVisibility(View.GONE);
        rvMovies.setVisibility(View.VISIBLE);
    }

    @Override
    public void setMovieList(DisMovieResponse movieList) {
        itemMovie = movieList.getResults();
        movieListAdapter.refill(itemMovie);
    }

    @Override
    public void onErrorLoading(String message) {
        pbLoading.setVisibility(View.GONE);
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onErrorData() {
        tvErrorGet.setVisibility(View.VISIBLE);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelableArrayList(KEY_MOVIES_LIST, itemMovie);
        super.onSaveInstanceState(outState);
    }
}

