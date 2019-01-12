package io.navendra.showtime.service

/**
 * A Kotlin Object (Java's Singleton Class) to create various APIs service
 */
object ApiFactory{

    val showsApiService : ShowsApiService = RetrofitFactory.retrofit().create(ShowsApiService::class.java)
}