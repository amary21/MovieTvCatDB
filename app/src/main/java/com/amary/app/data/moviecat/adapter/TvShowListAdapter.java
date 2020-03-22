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

public class TvShowListAdapter extends RecyclerView.Adapter<TvShowListAdapter.CategoryViewHolder>{
    private Context context;
    private ArrayList<MovieTvCatData> movieTvCatData;

    public TvShowListAdapter(Context context) {
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
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View item = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rv_list, viewGroup, false);
        return new CategoryViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int i) {
        categoryViewHolder.txtJudul.setText(getMovieTvCatData().get(i).getJudul());
        categoryViewHolder.txtTahunRilis.setText(getMovieTvCatData().get(i).getThnRilis());
        categoryViewHolder.txtDurasi.setText(getMovieTvCatData().get(i).getDurasiMovie());
        categoryViewHolder.txtGenre.setText(getMovieTvCatData().get(i).getGenreMovie());
        Glide.with(context)
                .load(getMovieTvCatData().get(i).getPoster())
                .into(categoryViewHolder.imgPoster);
    }

    @Override
    public int getItemCount() {
        return getMovieTvCatData().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgPoster;
        private TextView txtJudul;
        private TextView txtTahunRilis;
        private TextView txtDurasi;
        private TextView txtGenre;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPoster       = itemView.findViewById(R.id.img_poster);
            txtJudul        = itemView.findViewById(R.id.txt_judul);
            txtTahunRilis   = itemView.findViewById(R.id.txt_thn_rilis);
            txtDurasi       = itemView.findViewById(R.id.txt_durasi);
            txtGenre        = itemView.findViewById(R.id.txt_genre);
        }
    }
}
