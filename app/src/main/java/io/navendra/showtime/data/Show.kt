package io.navendra.showtime.data

import android.graphics.Bitmap
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
data class Show(
        val id:Int,
        val imdbId:Int,
        val title:String,
        val overview: String,
        val tagline: String,
        val adult:Boolean,
        val genres: Array<Genre>,
        val posterBitmap: Bitmap? = null,
        @Json(name = "release_date") val releaseData: Date,
        @Json(name = "vote_average") val rating:Double,
        @Json(name = "poster_path") val posterPath: String,
        @Json(name = "backdrop_path") val backdropPath: String){

    companion object
}