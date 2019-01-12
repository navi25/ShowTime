@file:JvmName("AppConstants")

package io.navendra.showtime


object AppConstants{

    var tmdbApiKey = BuildConfig.TMDB_API_KEY

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
        const val TMDB_BASE_URL = "https://api.themoviedb.org/3/"
        const val TMDB_PHOTO_URL = " http://image.tmdb.org/t/p/w185"
        const val DUMMY_POSTER_URL = "http://t2.gstatic.com/images?q=tbn:ANd9GcQW3LbpT94mtUG1PZIIzJNxmFX399wr_NcvoppJ82k7z99Hx6in"

        const val POPULAR_MOVIE_ENDPOINT = "movie/popular"
        const val NOW_PLAYING_MOVIE_ENDPOINT = "movie/now_playing"
        const val TOP_RATED_MOVIE_ENDPOINT = "movie/top_rated"
        const val UPCOMING_MOVIE_ENDPOINT = "movie/upcoming"
    }

}