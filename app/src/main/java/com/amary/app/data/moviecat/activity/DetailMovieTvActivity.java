package com.amary.app.data.moviecat.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.amary.app.data.moviecat.R;
import com.amary.app.data.moviecat.model.MovieTvCatData;
import com.squareup.picasso.Picasso;

import java.util.Objects;

public class DetailMovieTvActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie_tv);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getIncomingIntent();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    private void getIncomingIntent(){
        Intent intent = getIntent();
        MovieTvCatData movieTvCatData = intent.getParcelableExtra(EXTRA_MOVIE);

        ImageView imgPoster     = findViewById(R.id.img_info_poster);
        ImageView imgScreen1    = findViewById(R.id.img_screen_1);
        ImageView imgScreen2    = findViewById(R.id.img_screen_2);
        ImageView imgScreen3    = findViewById(R.id.img_screen_3);
        ImageView imgScreen4    = findViewById(R.id.img_screen_4);
        ImageView imgScreen5    = findViewById(R.id.img_screen_5);
        TextView txtTanggal     = findViewById(R.id.txt_info_tanggal);
        TextView txtDurasi      = findViewById(R.id.txt_info_durasi);
        TextView txtGenre       = findViewById(R.id.txt_info_genre);
        TextView txtDirector    = findViewById(R.id.txt_info_directors);
        TextView txtActor       = findViewById(R.id.txt_info_actors);
        TextView txtSinopsis    = findViewById(R.id.txt_info_overview);

        Objects.requireNonNull(getSupportActionBar()).setTitle(movieTvCatData.getJudul());
        txtTanggal.setText(movieTvCatData.getTglRilis());
        txtDurasi.setText(movieTvCatData.getDurasiMovie());
        txtGenre.setText(movieTvCatData.getGenreMovie());
        txtDirector.setText(movieTvCatData.getDirectors());
        txtActor.setText(movieTvCatData.getActors());
        txtSinopsis.setText(movieTvCatData.getSinopsis());
        imgPoster.setImageResource(movieTvCatData.getPoster());
        imgScreenShot(movieTvCatData.getScreen1(), imgScreen1);
        imgScreenShot(movieTvCatData.getScreen2(), imgScreen2);
        imgScreenShot(movieTvCatData.getScreen3(), imgScreen3);
        imgScreenShot(movieTvCatData.getScreen4(), imgScreen4);
        imgScreenShot(movieTvCatData.getScreen5(), imgScreen5);
    }

    private void imgScreenShot(int IMG_PATH, ImageView imageView){
        Picasso.get()
                .load(IMG_PATH)
                .into(imageView);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
