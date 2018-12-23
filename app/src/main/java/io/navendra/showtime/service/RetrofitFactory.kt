package io.navendra.showtime.service

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import io.navendra.showtime.AppConstants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import io.navendra.showtime.AppConstants.Network as NetworkConstants
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitFactory{

    private val interceptor = Interceptor {chain->
        val newUrl = chain.request().url()
                .newBuilder()
                .addQueryParameter("api_key", AppConstants.tmdbApiKey)
                .build()

        val newRequest = chain.request()
                .newBuilder()
                .url(newUrl)
                .build()

        chain.proceed(newRequest)
    }

    private val client = OkHttpClient().newBuilder()
            .addInterceptor(interceptor)
            .build()


    fun retrofit() : Retrofit{
        return Retrofit.Builder()
                .baseUrl(NetworkConstants.TMDB_BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .client(client)
                .build()
    }
}