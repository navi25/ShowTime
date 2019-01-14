//package io.navendra.showtime.data.storage.local
//
//import androidx.annotation.WorkerThread
//import androidx.lifecycle.MutableLiveData
//import io.navendra.showtime.data.model.Show
//
//class ShowRepository(private val showDAO: ShowDAO){
//
//    val fetchAllShows : MutableLiveData<List<Show>> = showDAO.getAllShows()
//
//    @WorkerThread
//    suspend fun insert(show: Show){
//        showDAO.insert(show)
//    }
//}