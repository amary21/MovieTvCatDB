package com.amary.app.data.moviecat.utils

import android.annotation.SuppressLint
import android.content.res.Resources
import com.amary.app.data.moviecat.R
import com.amary.app.data.moviecat.model.MovieCatData

object DataDummy {

    @SuppressLint("Recycle")
    fun getDummyMovies(resources: Resources) : ArrayList<MovieCatData>{
        val dataJudul = resources.getStringArray(R.array.judul_data)
        val dataThnRilis = resources.getStringArray(R.array.thn_rilis_data)
        val dataTglRilis = resources.getStringArray(R.array.tanggal_rilis_data)
        val dataDurasi = resources.getStringArray(R.array.durasi_data)
        val dataGenre = resources.getStringArray(R.array.genre_data)
        val dataDirectors = resources.getStringArray(R.array.director_data)
        val dataActors = resources.getStringArray(R.array.actors_data)
        val dataSinopsis = resources.getStringArray(R.array.sinopsis_data)
        val dataPoster = resources.obtainTypedArray(R.array.poster_data)
        val dataScreen1 = resources.obtainTypedArray(R.array.screen_1_data)
        val dataScreen2 = resources.obtainTypedArray(R.array.screen_2_data)
        val dataScreen3 = resources.obtainTypedArray(R.array.screen_3_data)
        val dataScreen4 = resources.obtainTypedArray(R.array.screen_4_data)
        val dataScreen5 = resources.obtainTypedArray(R.array.screen_5_data)

        val movieCatData = ArrayList<MovieCatData>()

        for (i in dataJudul.indices) {
            val movie = MovieCatData()
            movie.poster = dataPoster.getResourceId(i, -1)
            movie.screen1 = dataScreen1.getResourceId(i, -1)
            movie.screen2 = dataScreen2.getResourceId(i, -1)
            movie.screen3 = dataScreen3.getResourceId(i, -1)
            movie.screen4 = dataScreen4.getResourceId(i, -1)
            movie.screen5 = dataScreen5.getResourceId(i, -1)
            movie.judul = dataJudul[i]
            movie.thnRilis = dataThnRilis[i]
            movie.tglRilis = dataTglRilis[i]
            movie.durasiMovie = dataDurasi[i]
            movie.genreMovie = dataGenre[i]
            movie.directors = dataDirectors[i]
            movie.actors = dataActors[i]
            movie.sinopsis = dataSinopsis[i]
            movieCatData.add(movie)
        }

        return movieCatData
    }
}