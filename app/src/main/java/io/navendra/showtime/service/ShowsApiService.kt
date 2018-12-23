package io.navendra.showtime.service

import io.navendra.showtime.data.model.Show
import kotlinx.coroutines.Deferred
import retrofit2.Response
import io.navendra.showtime.AppConstants.Network as NetworkConstants
import retrofit2.http.GET


interface ShowsApiService{

    @GET(NetworkConstants.POPULAR_MOVIE_ENDPOINT)
    suspend fun getPopularShows() : Deferred<Response<MutableList<Show>>>

    @GET(NetworkConstants.NOW_PLAYING_MOVIE_ENDPOINT)
    suspend fun getNowPlayingShows() : Deferred<Response<MutableList<Show>>>

    @GET(NetworkConstants.TOP_RATED_MOVIE_ENDPOINT)
    suspend fun getTopRatedShows() : Deferred<Response<MutableList<Show>>>

    @GET(NetworkConstants.UPCOMING_MOVIE_ENDPOINT)
    suspend fun getUpcomingShows() : Deferred<Response<MutableList<Show>>>

}