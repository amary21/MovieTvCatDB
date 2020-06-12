package com.amary.app.data.moviecat.activity

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.amary.app.data.moviecat.R
import com.amary.app.data.moviecat.adapter.MovieCatAdapter
import com.amary.app.data.moviecat.model.MovieCatData
import com.amary.app.data.moviecat.utils.DataDummy
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = MovieCatAdapter(this)
        val movieCatData = DataDummy.getDummyMovies(resources)

        lv_moviecat.setHasFixedSize(true)
        lv_moviecat.layoutManager = LinearLayoutManager(this)
        lv_moviecat.adapter = adapter
        adapter.setMovieCatData(movieCatData)
    }
}