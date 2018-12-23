package io.navendra.showtime.service

object ApiFactory{

    val showsApiService = RetrofitFactory.retrofit().create(ShowsApiService::class.java)
}