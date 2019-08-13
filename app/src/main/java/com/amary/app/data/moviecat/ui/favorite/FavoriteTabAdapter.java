package com.amary.app.data.moviecat.ui.favorite;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.amary.app.data.moviecat.ui.favorite.movie.FavMovieFragment;
import com.amary.app.data.moviecat.ui.favorite.tvshow.FavTvShowsFragment;

public class FavoriteTabAdapter extends FragmentPagerAdapter {

    private int mNumbOfTabs;
    FavoriteTabAdapter(FragmentManager fm, int mNumbOfTabs) {
        super(fm);
        this.mNumbOfTabs = mNumbOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FavMovieFragment();
            case 1:
                return new FavTvShowsFragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumbOfTabs;
    }
}
