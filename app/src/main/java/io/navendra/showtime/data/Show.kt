package io.navendra.showtime.data

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.navendra.showtime.AppConstants.ShowTable as ShowConstants
import java.util.*

@Entity(tableName = ShowConstants.TABLE_NAME)
@JsonClass(generateAdapter = true)
data class Show(

        @PrimaryKey
        @ColumnInfo(name = ShowConstants.COLUMN_ID) val id:Int,

        @ColumnInfo(name = ShowConstants.COLUMN_IMDB_ID) val imdbId:Int,
        @ColumnInfo(name = ShowConstants.COLUMN_TITLE) val title:String,
        @ColumnInfo(name = ShowConstants.COLUMN_OVERVIEW) val overview: String,
        @ColumnInfo(name = ShowConstants.COLUMN_TAGLINE) val tagline: String,
        @ColumnInfo(name = ShowConstants.COLUMN_ADULT) val adult:Boolean,
        val genres: Array<Genre>,
        @ColumnInfo(name = ShowConstants.COLUMN_POSTER_BITMAP) val posterBitmap: Bitmap? = null,
        @ColumnInfo(name = ShowConstants.COLUMN_RELEASE_DATE) @Json(name = "release_date") val releaseData: Date,
        @ColumnInfo(name = ShowConstants.COLUMN_RATING) @Json(name = "vote_average") val rating:Double,
        @ColumnInfo(name = ShowConstants.COLUMN_POSTER_PATH) @Json(name = "poster_path") val posterPath: String,
        @ColumnInfo(name = ShowConstants.COLUMN_BACKDROP_PATH) @Json(name = "backdrop_path") val backdropPath: String) {

  companion object

}