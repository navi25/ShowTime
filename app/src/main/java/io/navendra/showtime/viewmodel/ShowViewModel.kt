package io.navendra.showtime.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import io.navendra.showtime.data.model.Genre
import io.navendra.showtime.data.model.ParentShowList
import io.navendra.showtime.data.model.Show
import io.navendra.showtime.service.ApiFactory
import io.navendra.showtime.service.ShowRepository
import kotlinx.coroutines.*
import retrofit2.HttpException
import retrofit2.Response
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

class ShowViewModel(application: Application) : AndroidViewModel(application){

    private var parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main
    private val scope = CoroutineScope(coroutineContext)

    val repository : ShowRepository = ShowRepository(ApiFactory.showsApiService)

    //get calls ensure computed property
    val allShows : MutableLiveData<MutableList<ParentShowList>>
        get() = createParentShowList()

    private val popularShows : MutableLiveData<MutableList<Show>>
        get() = transformToLiveData(repository.popularShows)

    private val upcomingShows: MutableLiveData<MutableList<Show>>
        get() = transformToLiveData(repository.upcomingShows)

    private val nowPlayingShows : MutableLiveData<MutableList<Show>>
        get() = transformToLiveData(repository.nowPlayingShows)

    private val topRatedShows: MutableLiveData<MutableList<Show>>
        get() = transformToLiveData(repository.topRatedShows)


    private fun transformToLiveData(movies : Deferred<Response<MutableList<Show>>>) : MutableLiveData<MutableList<Show>>{
        val shows = MutableLiveData<MutableList<Show>>()
        scope.launch(Dispatchers.IO) {
            try {
                shows.value = movies.await().body()
            }catch (e: HttpException){
                Log.d("ShowViewModel - HttpException ",e.message)
            } catch (e: Exception){
                Log.d("ShowViewModel - Exception", e.message)
            }

        }
        return shows
    }



    private fun createParentShowList() : MutableLiveData<MutableList<ParentShowList>>{
        val allShows = MutableLiveData<MutableList<ParentShowList>>()
        val list = mutableListOf<ParentShowList>()

        scope.launch(Dispatchers.IO){
            try{
                //Popular Show List
                val popular = ParentShowList(0, "POPULAR", popularShows.value)
                list.add(popular)

                //Upcoming Show List
                val upcoming = ParentShowList(0, "UPCOMING", upcomingShows.value)
                list.add(upcoming)

                //Popular Show List
                val nowPlaying = ParentShowList(0, "NOW PLAYING", nowPlayingShows.value)
                list.add(nowPlaying)

                //Upcoming Show List
                val topRated = ParentShowList(0, "TOP RATED", topRatedShows.value)
                list.add(topRated)

            }catch (e:HttpException){
                Log.d("ShowViewModel","HTTP_EXCEPTION in allShows- ${e.message}")
            }catch (e:Exception){
                Log.d("ShowViewModel","EXCEPTION in allShows- ${e.message}")
            }

        }
        allShows.value = list
        return allShows
    }








}