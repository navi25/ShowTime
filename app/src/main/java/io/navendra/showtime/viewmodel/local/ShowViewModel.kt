//package io.navendra.showtime.viewmodel.local
//
//import android.app.Application
//import androidx.lifecycle.AndroidViewModel
//import androidx.lifecycle.MutableLiveData
//import io.navendra.showtime.data.model.Show
//import io.navendra.showtime.data.storage.local.LocalShowDatabase
//import io.navendra.showtime.data.storage.local.ShowRepository
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.Job
//import kotlinx.coroutines.launch
//import kotlin.coroutines.CoroutineContext
//
//class ShowViewModel(application: Application) : AndroidViewModel(application){
//
//    private var parentJob = Job()
//    private val coroutineContext: CoroutineContext
//        get() = parentJob + Dispatchers.Main
//    private val scope = CoroutineScope(coroutineContext)
//
//    private val showRepository: ShowRepository
//    val allShows: MutableLiveData<List<Show>>
//
//    init {
//        val showDAO = LocalShowDatabase.getDatabase(application, scope).showDAO()
//        showRepository = ShowRepository(showDAO)
//        allShows = showRepository.allShows
//    }
//
//    fun insert(show: Show) = scope.launch(Dispatchers.IO) {
//        showRepository.insert(show)
//    }
//
//    override fun onCleared() {
//        super.onCleared()
//        parentJob.cancel()
//    }
//}