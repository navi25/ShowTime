package io.navendra.showtime.service

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import io.navendra.showtime.AppConstants.Network as NetworkConstants
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*

object RetrofitFactory{

    fun getRetrofit() : Retrofit{

        return Retrofit.Builder()
                .baseUrl(NetworkConstants.TMDB_BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
    }
}