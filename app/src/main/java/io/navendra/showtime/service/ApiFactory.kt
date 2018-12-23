package io.navendra.showtime.service

object ApiFactory{

    val tmdbApi = RetrofitFactory.retrofit().create(ShowsApiService::class.java)
}