package io.navendra.showtime.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import io.navendra.showtime.data.model.ParentShowList
import io.navendra.showtime.service.ApiFactory
import io.navendra.showtime.service.ShowRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class ShowViewModel(application: Application) : AndroidViewModel(application){

    private var parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main
    private val scope = CoroutineScope(coroutineContext)

    private val repository : ShowRepository = ShowRepository(ApiFactory.showsApiService,scope)

    //get calls ensure computed property
    fun allShows(callback : (MutableLiveData<MutableList<ParentShowList>>)->Unit) = repository.allShows(callback)

}