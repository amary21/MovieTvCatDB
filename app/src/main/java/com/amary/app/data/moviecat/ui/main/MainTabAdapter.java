package com.amary.app.data.moviecat.ui.main;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.amary.app.data.moviecat.ui.main.movie.MoviesFragment;
import com.amary.app.data.moviecat.ui.main.tvshow.TvShowFragment;

public class MainTabAdapter extends FragmentPagerAdapter {

    private int mNumOfTabs;

    MainTabAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new MoviesFragment();
            case 1:
                return new TvShowFragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

}
