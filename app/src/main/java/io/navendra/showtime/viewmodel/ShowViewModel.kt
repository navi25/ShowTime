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


    fun allShows(callback : (MutableLiveData<MutableList<ParentShowList>>)->Unit) = repository.allShows(callback)

    fun cancelAllRequests() = coroutineContext.cancel()

}