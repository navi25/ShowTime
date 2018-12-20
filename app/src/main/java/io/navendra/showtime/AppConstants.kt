@file:JvmName("AppConstants")

package io.navendra.showtime


object AppConstants{

    object ShowTable{
        const val DATABASE_NAME = "show_database"
        const val TABLE_NAME = "show_table"
        const val COLUMN_ID = "Id"
        const val COLUMN_IMDB_ID = "imdb_id"
        const val COLUMN_TITLE = "title"
        const val COLUMN_OVERVIEW = "overview"
        const val COLUMN_TAGLINE = "tagline"
        const val COLUMN_ADULT = "for_adult"
        const val COLUMN_GENRES = "genres"
        const val COLUMN_POSTER_BITMAP = "poster_bitmap"
        const val COLUMN_RELEASE_DATE = "release_date"
        const val COLUMN_RATING = "rating"
        const val COLUMN_POSTER_PATH = "poster_path"
        const val COLUMN_BACKDROP_PATH = "backdrop_path"

        object Queries{
            const val GET_ALL="SELECT * from $TABLE_NAME ORDER BY $COLUMN_TITLE ASC"
            const val DELETE_ALL = "DELETE from $TABLE_NAME"
        }
     }

    object Network{
        const val GET_SHOWS = "/movies"
        const val TMDB_BASE_URL = "https://api.themoviedb.org/3"
    }

}