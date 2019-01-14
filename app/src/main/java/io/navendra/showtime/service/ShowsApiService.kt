package io.navendra.showtime.service

import io.navendra.showtime.data.model.ShowResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import io.navendra.showtime.AppConstants.Network as NetworkConstants
import retrofit2.http.GET

/**
 * A Generic Retrofit APIs Service. Here we are using Kotlin's Deferred type as our return type,
 * instead of previously used Retrofit's Call as return type
 */
interface ShowsApiService{

    @GET(NetworkConstants.POPULAR_MOVIE_ENDPOINT)
    fun getPopularShows() : Deferred<Response<Result<ShowResponse>>>


    @GET(NetworkConstants.NOW_PLAYING_MOVIE_ENDPOINT)
    fun getNowPlayingShows() : Deferred<Response<Result<ShowResponse>>>


    @GET(NetworkConstants.TOP_RATED_MOVIE_ENDPOINT)
    fun getTopRatedShows() : Deferred<Response<Result<ShowResponse>>>


    @GET(NetworkConstants.UPCOMING_MOVIE_ENDPOINT)
    fun getUpcomingShows() : Deferred<Response<Result<ShowResponse>>>
}