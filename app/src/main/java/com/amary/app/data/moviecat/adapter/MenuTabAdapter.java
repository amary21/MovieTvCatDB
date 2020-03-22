package com.amary.app.data.moviecat.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.amary.app.data.moviecat.activity.fragment.MoviesFragment;
import com.amary.app.data.moviecat.activity.fragment.TvShowFragment;

public class MenuTabAdapter extends FragmentPagerAdapter {

    private int mNumOfTabs;

    public MenuTabAdapter(FragmentManager fm, int NumOfTabs) {
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
