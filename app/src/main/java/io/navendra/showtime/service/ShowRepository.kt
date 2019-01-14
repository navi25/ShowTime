package io.navendra.showtime.service

import androidx.lifecycle.MutableLiveData
import io.navendra.showtime.data.model.ParentShowList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


class ShowRepository(private val api : ShowsApiService, private val scope:CoroutineScope) : DataRepository(){


    enum class ShowType{ POPULAR, UPCOMING, TOP_RATED, NOW_PLAYING }

    suspend fun nullableShows(type: ShowType) = when(type){

        ShowType.POPULAR ->
            safeApiCall(
                call = {api.getPopularShows().await()},
                errorMessage = "Error Fetching Popular Shows"
            )

        ShowType.NOW_PLAYING ->
            safeApiCall(
                    call = {api.getNowPlayingShows().await()},
                    errorMessage = "Error Fetching Upcoming Shows"
            )

        ShowType.TOP_RATED ->
            safeApiCall(
                    call = {api.getTopRatedShows().await()},
                    errorMessage = "Error Fetching Popular Shows"
            )

        ShowType.UPCOMING ->
            safeApiCall(
                    call = {api.getUpcomingShows().await()},
                    errorMessage = "Error Fetching Upcoming Shows"
            )
    }



    fun allShows(callback : (MutableLiveData<MutableList<ParentShowList>>)->Unit)  = scope.launch {


        val allShows = MutableLiveData<MutableList<ParentShowList>>()
        val list = mutableListOf<ParentShowList>()

        val popularShows = nullableShows(ShowType.POPULAR)?.results?.toMutableList()
        val upcomingShows = nullableShows(ShowType.UPCOMING)?.results?.toMutableList()


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