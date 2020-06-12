package com.amary.app.data.moviecat.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.amary.app.data.moviecat.R;
import com.amary.app.data.moviecat.model.MovieCatData;
import com.squareup.picasso.Picasso;

public class DetailMovieActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getIncomingIntent();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


    }

    private void getIncomingIntent(){
        Intent intent = getIntent();
        MovieCatData movieCatData = intent.getParcelableExtra(EXTRA_MOVIE);

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

        getSupportActionBar().setTitle(movieCatData.getJudul());
        txtTanggal.setText(movieCatData.getTglRilis());
        txtDurasi.setText(movieCatData.getDurasiMovie());
        txtGenre.setText(movieCatData.getGenreMovie());
        txtDirector.setText(movieCatData.getDirectors());
        txtActor.setText(movieCatData.getActors());
        txtSinopsis.setText(movieCatData.getSinopsis());
        imgPoster.setImageResource(movieCatData.getPoster());
        imgScreenShot(movieCatData.getScreen1(), imgScreen1);
        imgScreenShot(movieCatData.getScreen2(), imgScreen2);
        imgScreenShot(movieCatData.getScreen3(), imgScreen3);
        imgScreenShot(movieCatData.getScreen4(), imgScreen4);
        imgScreenShot(movieCatData.getScreen5(), imgScreen5);
    }

    public void imgScreenShot(int IMG_PATH, ImageView imageView){
        Picasso.get()
                .load(IMG_PATH)
                .resize(235,131)
                .into(imageView);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
