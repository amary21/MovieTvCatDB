package com.amary.app.data.moviecat.base;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.amary.app.data.moviecat.ui.detail.movie.DetailMoviePresenter;
import com.amary.app.data.moviecat.ui.detail.tvshow.DetailTvPresenter;
import com.androidnetworking.AndroidNetworking;

@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {

    protected static final String KEY_DETAIL_MOVIE = "movie_det";
    protected static final String KEY_IMAGE_MOVIE = "image_movie";

    protected static final String KEY_DETAIL_TV = "tv_det";
    protected static final String KEY_IMAGE_TV = "image_tv";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidNetworking.initialize(this);
    }

    protected DetailMoviePresenter getDetailMoviePresenter() {
        return new DetailMoviePresenter();
    }

    protected DetailTvPresenter getDetailTvPresenter() {
        return new DetailTvPresenter();
    }
}
