package io.navendra.showtime.service

import io.navendra.showtime.data.model.Show
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import io.navendra.showtime.AppConstants.Network as NetworkConstants
import retrofit2.http.GET


interface ShowsApiService{

    //popular, top rated, now playing, upcoming

    @GET(NetworkConstants.POPULAR_MOVIE_ENDPOINT)
    fun getPopularMovies() : Deferred<Response<List<Show>>>

    @GET(NetworkConstants.NOW_PLAYING_MOVIE_ENDPOINT)
    fun getNowPlayingMovies() : Deferred<Response<List<Show>>>

    @GET(NetworkConstants.TOP_RATED_MOVIE_ENDPOINT)
    fun getTopRatedMovies() : Deferred<Response<List<Show>>>

    @GET(NetworkConstants.UPCOMING_MOVIE_ENDPOINT)
    fun getUpcomingMovies() : Deferred<Response<List<Show>>>

}