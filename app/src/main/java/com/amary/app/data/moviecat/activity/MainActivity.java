package com.amary.app.data.moviecat.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.amary.app.data.moviecat.R;
import com.amary.app.data.moviecat.activity.fragment.MoviesFragment;
import com.amary.app.data.moviecat.activity.fragment.TvShowFragment;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new
            BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment fragment;
            switch (menuItem.getItemId()){
                case R.id.nv_movie:
                    //fragment movie
                    fragment = new MoviesFragment();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fl_container, fragment)
                            .commit();
                    Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.tvshow);
                    return true;
                case R.id.nv_tvshow:
                    //fragment tvshow
                    fragment = new TvShowFragment();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fl_container, fragment)
                            .commit();
                    Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.tvshow);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView naviBottom = findViewById(R.id.bnv_layout);
        naviBottom.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        if (savedInstanceState == null){
            naviBottom.setSelectedItemId(R.id.nv_movie);
            Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.movies);
        }

    }
}
