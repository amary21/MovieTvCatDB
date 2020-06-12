package com.amary.app.data.moviecat.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieTvCatData (
    var poster: Int = 0,
    var screen1: Int = 0,
    var screen2: Int = 0,
    var screen3: Int = 0,
    var screen4: Int = 0,
    var screen5: Int = 0,
    var judul: String? = null,
    var thnRilis: String? = null,
    var durasiMovie: String? = null,
    var genreMovie: String? = null,
    var tglRilis: String? = null,
    var directors: String? = null,
    var actors: String? = null,
    var sinopsis: String? = null
) : Parcelable