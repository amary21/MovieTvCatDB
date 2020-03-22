package com.amary.app.data.moviecat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.amary.app.data.moviecat.R;
import com.amary.app.data.moviecat.model.MovieCatData;

import java.util.ArrayList;

public class MovieCatAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<MovieCatData> movieCatData;

    public void setMovieCatData(ArrayList<MovieCatData> movieCatData) {
        this.movieCatData = movieCatData;
    }

    public MovieCatAdapter(Context context) {
        this.context = context;
        movieCatData = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return movieCatData.size();
    }

    @Override
    public Object getItem(int position) {
        return movieCatData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view ==null){
            view = LayoutInflater.from(context).inflate(R.layout.item_moviecat, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        MovieCatData movieCatData = (MovieCatData) getItem(position);
        viewHolder.bind(movieCatData);
        return view;
    }

    private class ViewHolder{
        private ImageView imgPoster;
        private TextView txtJudul;
        private TextView txtTahunRilis;
        private TextView txtDurasi;
        private TextView txtGenre;

        ViewHolder(View view){
            imgPoster       = view.findViewById(R.id.img_poster);
            txtJudul        = view.findViewById(R.id.txt_judul);
            txtTahunRilis   = view.findViewById(R.id.txt_thn_rilis);
            txtDurasi       = view.findViewById(R.id.txt_durasi);
            txtGenre        = view.findViewById(R.id.txt_genre);
        }

        void bind(MovieCatData movieCatData){
            imgPoster.setImageResource(movieCatData.getPoster());
            txtJudul.setText(movieCatData.getJudul());
            txtTahunRilis.setText(movieCatData.getThnRilis());
            txtDurasi.setText(movieCatData.getDurasiMovie());
            txtGenre.setText(movieCatData.getGenreMovie());
        }
    }
}


