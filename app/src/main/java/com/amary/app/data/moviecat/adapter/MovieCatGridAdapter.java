package com.amary.app.data.moviecat.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amary.app.data.moviecat.R;
import com.amary.app.data.moviecat.model.MovieTvCatData;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MovieCatGridAdapter extends RecyclerView.Adapter<MovieCatGridAdapter.GridViewHolder> {
    private Context context;
    private ArrayList<MovieTvCatData> movieTvCatData;

    public MovieCatGridAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<MovieTvCatData> getMovieTvCatData() {
        return movieTvCatData;
    }

    public void setMovieTvCatData(ArrayList<MovieTvCatData> movieTvCatData) {
        this.movieTvCatData = movieTvCatData;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rv_grid,viewGroup, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder gridViewHolder, int i) {
        gridViewHolder.txtJudul.setText(getMovieTvCatData().get(i).getJudul());
        gridViewHolder.txtTahunRilis.setText(getMovieTvCatData().get(i).getThnRilis());
        gridViewHolder.txtDurasi.setText(getMovieTvCatData().get(i).getDurasiMovie());
        gridViewHolder.txtGenre.setText(getMovieTvCatData().get(i).getGenreMovie());
        Glide.with(context)
                .load(getMovieTvCatData().get(i).getPoster())
                .into(gridViewHolder.imgPoster);
    }

    @Override
    public int getItemCount() {
        return getMovieTvCatData().size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgPoster;
        private TextView txtJudul;
        private TextView txtTahunRilis;
        private TextView txtDurasi;
        private TextView txtGenre;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPoster       = itemView.findViewById(R.id.img_gd_poster);
            txtJudul        = itemView.findViewById(R.id.tv_gd_judul);
            txtTahunRilis   = itemView.findViewById(R.id.tv_gd_thn_rilis);
            txtDurasi       = itemView.findViewById(R.id.tv_gd_durasi);
            txtGenre        = itemView.findViewById(R.id.tv_gd_genre);
        }
    }
}
