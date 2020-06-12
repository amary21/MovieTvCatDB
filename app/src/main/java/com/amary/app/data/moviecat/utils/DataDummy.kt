package com.amary.app.data.moviecat.utils

import android.content.res.Resources
import android.content.res.TypedArray
import com.amary.app.data.moviecat.R
import com.amary.app.data.moviecat.model.MovieTvCatData

object DataDummy {

    private var dataPoster: TypedArray? = null
    private var dataScreen1: TypedArray? = null
    private var dataScreen2: TypedArray? = null
    private var dataScreen3: TypedArray? = null
    private var dataScreen4: TypedArray? = null
    private var dataScreen5: TypedArray? = null
    private var dataJudul: Array<String>? = null
    private var dataThnRilis: Array<String>? = null
    private var dataTglRilis: Array<String>? = null
    private var dataDurasi: Array<String>? = null
    private var dataGenre: Array<String>? = null
    private var dataDirectors: Array<String>? = null
    private var dataActors: Array<String>? = null
    private var dataSinopsis: Array<String>? = null

    private var movieTvCatData = ArrayList<MovieTvCatData>()

    fun getDummyMovies(resources: Resources) : ArrayList<MovieTvCatData>{
        movieTvCatData = ArrayList()

        dataJudul = resources.getStringArray(R.array.judul_data)
        dataThnRilis = resources.getStringArray(R.array.thn_rilis_data)
        dataTglRilis = resources.getStringArray(R.array.tanggal_rilis_data)
        dataDurasi = resources.getStringArray(R.array.durasi_data)
        dataGenre = resources.getStringArray(R.array.genre_data)
        dataDirectors = resources.getStringArray(R.array.director_data)
        dataActors = resources.getStringArray(R.array.actors_data)
        dataSinopsis = resources.getStringArray(R.array.sinopsis_data)
        dataPoster = resources.obtainTypedArray(R.array.poster_data)
        dataScreen1 = resources.obtainTypedArray(R.array.screen_1_data)
        dataScreen2 = resources.obtainTypedArray(R.array.screen_2_data)
        dataScreen3 = resources.obtainTypedArray(R.array.screen_3_data)
        dataScreen4 = resources.obtainTypedArray(R.array.screen_4_data)
        dataScreen5 = resources.obtainTypedArray(R.array.screen_5_data)

        for (i in dataJudul?.indices!!) {
            val movie = MovieTvCatData()
            val getItem = getItemData(movie, i)
            movieTvCatData.add(getItem)
        }

        return movieTvCatData
    }

    fun getDummyTvshows(resources: Resources) : ArrayList<MovieTvCatData>{
        movieTvCatData = ArrayList()

        dataJudul = resources.getStringArray(R.array.judul_tvshow)
        dataThnRilis = resources.getStringArray(R.array.thn_rilis_tvshow)
        dataTglRilis = resources.getStringArray(R.array.tanggal_rilis_tvshow)
        dataDurasi = resources.getStringArray(R.array.durasi_tvshow)
        dataGenre = resources.getStringArray(R.array.genre_tvshow)
        dataDirectors = resources.getStringArray(R.array.creator_tvshow)
        dataActors = resources.getStringArray(R.array.actors_tvshow)
        dataSinopsis = resources.getStringArray(R.array.sinopsis_tvshow)
        dataPoster = resources.obtainTypedArray(R.array.poster_tvshow)
        dataScreen1 = resources.obtainTypedArray(R.array.screen_1_tvshow)
        dataScreen2 = resources.obtainTypedArray(R.array.screen_2_tvshow)
        dataScreen3 = resources.obtainTypedArray(R.array.screen_3_tvshow)
        dataScreen4 = resources.obtainTypedArray(R.array.screen_4_tvshow)
        dataScreen5 = resources.obtainTypedArray(R.array.screen_5_tvshow)

        for (i in dataJudul?.indices!!) {
            val tv = MovieTvCatData()
            val getItem = getItemData(tv, i)
            movieTvCatData.add(getItem)
        }

        return movieTvCatData
    }

    private fun getItemData(item: MovieTvCatData, i: Int): MovieTvCatData {
        item.poster = dataPoster!!.getResourceId(i, -1)
        item.screen1 = dataScreen1!!.getResourceId(i, -1)
        item.screen2 = dataScreen2!!.getResourceId(i, -1)
        item.screen3 = dataScreen3!!.getResourceId(i, -1)
        item.screen4 = dataScreen4!!.getResourceId(i, -1)
        item.screen5 = dataScreen5!!.getResourceId(i, -1)
        item.judul = dataJudul?.get(i)
        item.thnRilis = dataThnRilis?.get(i)
        item.tglRilis = dataTglRilis?.get(i)
        item.durasiMovie = dataDurasi?.get(i)
        item.genreMovie = dataGenre?.get(i)
        item.directors = dataDirectors?.get(i)
        item.actors = dataActors?.get(i)
        item.sinopsis = dataSinopsis?.get(i)

        return item
    }
}