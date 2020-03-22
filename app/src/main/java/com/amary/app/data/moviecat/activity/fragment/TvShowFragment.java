package com.amary.app.data.moviecat.activity.fragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.amary.app.data.moviecat.R;
import com.amary.app.data.moviecat.activity.DetailTvActivity;
import com.amary.app.data.moviecat.activity.SettingActivity;
import com.amary.app.data.moviecat.adapter.TvShowListAdapter;
import com.amary.app.data.moviecat.base.BaseFragment;
import com.amary.app.data.moviecat.model.DisTvResponse;
import com.amary.app.data.moviecat.model.ResultTv;
import com.amary.app.data.moviecat.view.TvShowListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowFragment extends BaseFragment implements TvShowListView {
    private ArrayList<ResultTv> itemTv = new ArrayList<>();
    private TvShowListAdapter tvShowListAdapter;

    @BindView(R.id.rv_movies)
    RecyclerView rvTvShows;
    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;
    @BindView(R.id.tv_error_get)
    TextView tvErrorGet;

    public TvShowFragment() {
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        String bhsLocal = getString(R.string.localization);
        setHasOptionsMenu(true);

        showData();

        if (savedInstanceState == null){
            getTvDataPresenter().getTvList(bhsLocal,this);
        }else {
            itemTv = savedInstanceState.getParcelableArrayList(KEY_TV_LIST);
            tvShowListAdapter.refill(itemTv);
        }


    }

    private void showData(){
        tvShowListAdapter = new TvShowListAdapter(itemTv);
        rvTvShows.setHasFixedSize(true);
        rvTvShows.setLayoutManager(new LinearLayoutManager(getContext()));
        rvTvShows.setAdapter(tvShowListAdapter);
        tvShowListAdapter.setOnItemClickListener((view, position) -> {
            Intent intent = new Intent(getActivity(), DetailTvActivity.class);
            intent.putExtra(DetailTvActivity.EXTRA_TV, itemTv.get(position));
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
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showLoading() {
        pbLoading.setVisibility(View.VISIBLE);
        rvTvShows.setVisibility(View.GONE);
        tvErrorGet.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        pbLoading.setVisibility(View.GONE);
        tvErrorGet.setVisibility(View.GONE);
        rvTvShows.setVisibility(View.VISIBLE);
    }

    @Override
    public void setTvList(DisTvResponse tvList) {
        itemTv = tvList.getResults();
        tvShowListAdapter.refill(itemTv);
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
        outState.putParcelableArrayList(KEY_TV_LIST, itemTv);
        super.onSaveInstanceState(outState);
    }
}
