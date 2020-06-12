package com.amary.app.data.moviecat.activity

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.amary.app.data.moviecat.R
import com.amary.app.data.moviecat.model.MovieTvCatData
import com.squareup.picasso.Picasso
import java.util.*

class DetailMovieTvActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie_tv)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        incomingIntent
        Objects.requireNonNull(supportActionBar)!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
    }

    private val incomingIntent: Unit
        get() {
            val intent = intent
            val (poster, screen1, screen2, screen3, screen4, screen5, judul, _, durasiMovie, genreMovie, tglRilis, directors, actors, sinopsis)
                    = intent.getParcelableExtra(EXTRA_MOVIE) as MovieTvCatData

            val imgPoster = findViewById<ImageView>(R.id.img_info_poster)
            val imgScreen1 = findViewById<ImageView>(R.id.img_screen_1)
            val imgScreen2 = findViewById<ImageView>(R.id.img_screen_2)
            val imgScreen3 = findViewById<ImageView>(R.id.img_screen_3)
            val imgScreen4 = findViewById<ImageView>(R.id.img_screen_4)
            val imgScreen5 = findViewById<ImageView>(R.id.img_screen_5)
            val txtTanggal = findViewById<TextView>(R.id.txt_info_tanggal)
            val txtDurasi = findViewById<TextView>(R.id.txt_info_durasi)
            val txtGenre = findViewById<TextView>(R.id.txt_info_genre)
            val txtDirector = findViewById<TextView>(R.id.txt_info_directors)
            val txtActor = findViewById<TextView>(R.id.txt_info_actors)
            val txtSinopsis = findViewById<TextView>(R.id.txt_info_overview)

            supportActionBar?.title = judul
            txtTanggal.text = tglRilis
            txtDurasi.text = durasiMovie
            txtGenre.text = genreMovie
            txtDirector.text = directors
            txtActor.text = actors
            txtSinopsis.text = sinopsis
            imgPoster.setImageResource(poster)
            imgScreenShot(screen1, imgScreen1)
            imgScreenShot(screen2, imgScreen2)
            imgScreenShot(screen3, imgScreen3)
            imgScreenShot(screen4, imgScreen4)
            imgScreenShot(screen5, imgScreen5)
        }

    private fun imgScreenShot(IMG_PATH: Int, imageView: ImageView) {
        Picasso.get()
                .load(IMG_PATH)
                .into(imageView)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }
}