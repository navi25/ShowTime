package io.navendra.showtime.service

import androidx.lifecycle.MutableLiveData
import io.navendra.showtime.data.model.ParentShowList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


class ShowRepository(private val api : ShowsApiService, private val scope:CoroutineScope){


    val popularShows = scope.async {  api.getPopularShows().await().body() }
    val upcomingShows = scope.async {  api.getUpcomingShows().await().body() }

    val nowPlayingShows = scope.async {  api.getNowPlayingShows().await().body() }
    val topRatedShows = scope.async {  api.getTopRatedShows().await().body() }

    fun allShows(callback : (MutableLiveData<MutableList<ParentShowList>>)->Unit)  = scope.launch {

        val popular = popularShows.await()
        val upcoming = upcomingShows.await()

        val allShows = MutableLiveData<MutableList<ParentShowList>>()
        val list = mutableListOf<ParentShowList>()

        //Popular Show List
        val popularShowList = ParentShowList(0, "POPULAR", popular)
        list.add(popularShowList)

        //Upcoming Show List
        val upcomingShowList = ParentShowList(0, "UPCOMING", upcoming)
        list.add(upcomingShowList)

        allShows.value = list

        callback(allShows)
    }

}