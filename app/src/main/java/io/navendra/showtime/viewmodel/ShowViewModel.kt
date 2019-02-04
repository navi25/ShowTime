package io.navendra.showtime.viewmodel

import androidx.lifecycle.MutableLiveData
import io.navendra.showtime.data.model.ParentShowList
import io.navendra.showtime.service.ApiFactory
import io.navendra.showtime.service.ShowRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


class ShowViewModel : BaseViewModel(){

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    private val repository : ShowRepository = ShowRepository(ApiFactory.showsApiService,scope)


    val allShows = MutableLiveData<MutableList<ParentShowList>>()

    fun fetchAllShows(){



        scope.launch {
            val allShowsList = repository.fetchAllShows()
            allShows.postValue(allShowsList)
        }
    }






    fun cancelAllRequests() = coroutineContext.cancel()

}