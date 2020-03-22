package com.amary.app.data.moviecat.base;

import androidx.fragment.app.Fragment;

import com.amary.app.data.moviecat.presenter.MovieDataPresenter;
import com.amary.app.data.moviecat.presenter.TvDataPresenter;

public class BaseFragment extends Fragment {

    protected static final String KEY_MOVIES_LIST = "movies_list";

    protected static final String KEY_TV_LIST = "tv_list";

    protected MovieDataPresenter getMovieDataPresenter(){
        return new MovieDataPresenter();
    }

    protected TvDataPresenter getTvDataPresenter(){
        return new TvDataPresenter();
    }
}
