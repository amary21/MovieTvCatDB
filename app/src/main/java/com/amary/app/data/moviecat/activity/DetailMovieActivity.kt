package com.amary.app.data.moviecat.activity

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.amary.app.data.moviecat.R
import com.amary.app.data.moviecat.model.MovieCatData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_movie.*
import kotlinx.android.synthetic.main.content_detail_movie.*

class DetailMovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        incomingIntent
    }

    private val incomingIntent: Unit
        get() {

            val movieCatData: MovieCatData = intent.getParcelableExtra(EXTRA_MOVIE)

            supportActionBar?.title = movieCatData.judul
            txt_info_tanggal.text = movieCatData.tglRilis
            txt_info_durasi.text = movieCatData.durasiMovie
            txt_info_genre.text = movieCatData.genreMovie
            txt_info_directors.text = movieCatData.directors
            txt_info_actors.text = movieCatData.actors
            txt_info_overview.text = movieCatData.sinopsis
            img_info_poster.setImageResource(movieCatData.poster)
            imgScreenShot(movieCatData.screen1, img_screen_1)
            imgScreenShot(movieCatData.screen2, img_screen_2)
            imgScreenShot(movieCatData.screen3, img_screen_3)
            imgScreenShot(movieCatData.screen4, img_screen_4)
            imgScreenShot(movieCatData.screen5, img_screen_5)
        }

    private fun imgScreenShot(IMG_PATH: Int, imageView: ImageView?) {
        Picasso.get()
                .load(IMG_PATH)
                .resize(235, 131)
                .into(imageView)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }
}