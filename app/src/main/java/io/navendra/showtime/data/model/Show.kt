package io.navendra.showtime.data.model

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import java.util.*
import io.navendra.showtime.AppConstants.ShowTable as ShowConstants

@Entity(tableName = ShowConstants.TABLE_NAME)
data class Show(

        @PrimaryKey
        @ColumnInfo(name = ShowConstants.COLUMN_ID) val id:Int,

        @ColumnInfo(name = ShowConstants.COLUMN_TITLE) val title:String,
        @ColumnInfo(name = ShowConstants.COLUMN_OVERVIEW) val overview: String,
        @ColumnInfo(name = ShowConstants.COLUMN_ADULT) val adult:Boolean,
//        val genres: Array<Genre>,
        @ColumnInfo(name = ShowConstants.COLUMN_RELEASE_DATE) @Json(name = "release_date") val releaseData: String,
        @ColumnInfo(name = ShowConstants.COLUMN_RATING) @Json(name = "vote_average") val rating:Double,
        @ColumnInfo(name = ShowConstants.COLUMN_POSTER_PATH) val poster_path: String,
        @ColumnInfo(name = ShowConstants.COLUMN_BACKDROP_PATH) @Json(name = "backdrop_path") val backdropPath: String

)
{
//        companion object {
//                private val random = Random()
//                fun random() = Show(random.nextInt(), random.nextInt(), random.nextDouble().toString(),
//                        random.nextDouble().toString(), random.nextDouble().toString(), false)
//        }

}