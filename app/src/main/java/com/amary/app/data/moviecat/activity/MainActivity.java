package com.amary.app.data.moviecat.activity;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.amary.app.data.moviecat.adapter.MenuTabAdapter;
import com.amary.app.data.moviecat.base.BaseActivity;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.amary.app.data.moviecat.R.id;
import static com.amary.app.data.moviecat.R.layout;

public class MainActivity extends BaseActivity {

    @BindView(id.tab_menu)
    TabLayout tabMenu;
    @BindView(id.fl_container)
    ViewPager viewMenu;
    @BindView(id.toolbar_main)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        MenuTabAdapter adapter = new MenuTabAdapter(getSupportFragmentManager(), tabMenu.getTabCount());
        viewMenu.setAdapter(adapter);
        viewMenu.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabMenu));
        tabMenu.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewMenu.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }
            @Override
            public void onTabReselected(TabLayout.Tab tab) { }
        });


    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

}
