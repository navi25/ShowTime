package io.navendra.showtime.service

import androidx.lifecycle.MutableLiveData
import io.navendra.showtime.data.model.ParentShowList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


class ShowRepository(private val api : ShowsApiService, private val scope:CoroutineScope){


    private val popularShows =  api.getPopularShows()
    private val upcomingShows = api.getUpcomingShows()

    private val nowPlayingShows = api.getNowPlayingShows()
    private val topRatedShows =  api.getTopRatedShows()

    fun allShows(callback : (MutableLiveData<MutableList<ParentShowList>>)->Unit)  = scope.launch {

        val popularResponse = popularShows.await().body()
        val upcomingResponse = upcomingShows.await().body()

        val allShows = MutableLiveData<MutableList<ParentShowList>>()
        val list = mutableListOf<ParentShowList>()

        val popularShows = popularResponse?.results?.toMutableList()
        val upcomingShows = upcomingResponse?.results?.toMutableList()


        //Popular Show List
        val popularShowList = ParentShowList(0, "POPULAR", popularShows)
        list.add(popularShowList)

        //Upcoming Show List
        val upcomingShowList = ParentShowList(0, "UPCOMING", upcomingShows)
        list.add(upcomingShowList)

        allShows.value = list


        callback(allShows)
    }

}